package org.tests;


import org.helpers.HelpProperties;
import org.helpers.Spec;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.pojo.Addition;
import org.pojo.EntityData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.helpers.GetEntry.getEntityByID;
import static org.helpers.GetEntry.getIdEntity;
import static org.helpers.Spec.reqSpec;


public class CreateTest {
    @BeforeClass
    public static void setup() {
        HelpProperties.createProperty();
    }

    @Test
    public void createEntityTest() {
        Addition addition = new Addition("first", 1);
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(11, 12, 13));
        EntityData entity = new EntityData(addition, list, "First Entity", true);
        Spec.reqSpec()
                .when()
                .basePath("api/create")
                .body(entity)
                .post()
                .then();
        Assert.assertNotNull(entity);

    }

    @Test
    public void getAllEntityByVerifiedTest() {
        List<EntityData> entity = reqSpec()
                .when()
                .basePath("api/getAll")
                .queryParam("verified", "true")
                .get()
                .then().extract()
                .body()
                .jsonPath()
                .getList("entity", EntityData.class);
        Assert.assertNotEquals(0, entity.size());
    }

    @Test
    public void getEntityByIdTest() {
        Integer id = getIdEntity();
        EntityData entity = getEntityByID(id);
        Assert.assertEquals(id, entity.getId());
    }

    @Test
    public void changeEntityByIdTest() {
        Integer id = getIdEntity();
        EntityData entity = getEntityByID(id);
        entity.setAddition(new Addition(33, "second Alerting", 2));
        entity.setTitle("Alerting entity");
        reqSpec()
                .basePath("api/patch/" + id)
                .body(entity)
                .when()
                .patch()
                .then();
        EntityData changeEntity = getEntityByID(id);
        Assert.assertNotNull(entity);
        Assert.assertNotNull(changeEntity);
        Assert.assertNotEquals(entity, changeEntity);
    }

    @Test
    public void deleteEntityByIdTest() {
        Integer id = getIdEntity();
        reqSpec()
                .basePath("api/delete/" + id)
                .when()
                .delete()
                .then()
                .statusCode(204);
    }
}
