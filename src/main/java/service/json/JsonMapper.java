package service.json;

public interface JsonMapper {

    /**
     * Создает Java объект (сущность из пакета {@code entity}) на основе JSON-объекта.
     *
     * @param jsonObject входящий JSON объект
     * @param clazz      класс Java объекта
     * @param <T>        Типизация (должна соответствовать классу)
     *
     */
    <T> T jsonObjectToEntity(JsonObject jsonObject, Class<T> clazz);

    /**
     * Сериализует Java объект в строковое JSON представление
     */
    String entityToString(Object entity);

    /**
     * Парсит JSON строку и создает на её основе Json-объект.
     */
   // JsonObject stringToJsonObject(String source);

}
