package com.stan.gamepedia.model;

public class FinderModel {

    private String typeId;
    private String typeName;
    private String columnName;
    private String target;

    public FinderModel(String typeId,String typeName,String columnName,String target){
        super();
        this.typeId = typeId;
        this.typeName = typeName;
        this.columnName = columnName;
        this.target = target;
    }


    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
