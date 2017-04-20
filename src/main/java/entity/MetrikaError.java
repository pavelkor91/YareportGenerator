package entity;
import org.codehaus.jackson.annotate.JsonProperty;

public class MetrikaError {
        @JsonProperty
        private String code;
        @JsonProperty
        private String text;
        @JsonProperty
        private Integer id;


        public MetrikaError(Integer id, String text, String code) {
            this.id = id;
            this.text = text;
            this.code = code;
        }

        /**
         * Код ошибки.
         *
         * @see <a href="http://api.yandex.ru/metrika/doc/ref/reference/error-codes.xml">список кодов</a>
         */
        public String getCode() {
            return code;
        }

        /** Текcтовое описание ошибки  (если есть) */
        public String getText() {
            return text;
        }

        public Integer getId() {
            return id;
        }


        public MetrikaError() {
        }

}
