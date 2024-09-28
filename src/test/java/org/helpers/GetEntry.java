package org.helpers;

import org.pojo.EntityData;

import java.util.List;

public class GetEntry {
    public static Integer getIdEntity() {
        List<EntityData> entity = Spec.reqSpec()
                .basePath("api/getAll")
                .queryParam("page", 1)
                .when()
                .get()
                .then()
                .extract()
                .body().jsonPath()
                .getList("entity", EntityData.class);
        return entity.get(0).getId();
    }

    public static EntityData getEntityByID(Integer id) {
        EntityData entity = Spec.reqSpec()
                .basePath("api/get/" + id)
                .when()
                .get()
                .then()
                .extract().as(EntityData.class);
        return entity;
    }

}
