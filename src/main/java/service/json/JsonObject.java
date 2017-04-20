package service.json;

/**
 * Created by Павел on 20.04.2017.
 */
public interface JsonObject {
    /**
     * Возвращает целочисленное значение поля в JSON объекте или null, если такого поля не существует, или
     * значение поля невозможно привести к типу Integer
     */
    Integer getIntField(String fieldName);

    /**
     * Возвращает строковое значение поля в JSON объекте или null, если такого поля не существует, или
     * значение поля невозможно привести к типу String
     */
    String getStringField(String fieldName);

    /**
     * Возвращает значение поля в JSON объекте или null, если такого поля не существует, или
     * значение поля невозможно привести к типу Double
     */
    Double getDoubleField(String fieldName);

    /**
     * Возвращает значение поля в JSON объекте, тоже являющееся JSON объектом, или null,
     * если такого поля не существует, или
     * значение поля не является JSON объектом
     */
    JsonObject getObjectField(String fieldName);

    /**
     * Возвращает значение поля в JSON объекте, являющееся массивом JSON объектов, или null,
     * если такого поля не существует, или
     * значение поля не является массивом JSON объектов
     */
    JsonObject[] getObjectArray(String fieldName);

    /** Возвращает true если в JSON объекте есть поле с заданным именем */
    boolean hasField(String fieldName);
}
