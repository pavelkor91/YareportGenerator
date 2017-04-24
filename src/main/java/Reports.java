import entity.Counter;

public enum Reports {
    /**

     * Отчёт Трафик -> Посещаемость.

     * https://tech.yandex.ru/metrika/doc/api2/api_v1/presets/preset_traffic-docpage/

     */

    trafficSummary("/stat/v1/data?present=traffic"),

    /**

     * Отчёт Трафик -> По времени суток.

     */

    trafficHourly("/stat/v1/data?present=hourly"),


    /**

    /**

     * Отчёт Источники -> Сайты.

     *

     * https://tech.yandex.ru/metrika/doc/api2/api_v1/presets/preset_sources-docpage/

     */

    sourcesSites("/stat/v1/data?present=sources_sites"),



    /**

     * Отчёт Источники -> Поисковые системы.

     */

    sourcesSearchEngines("/stat/v1/data?present=search_engines"),

    /**

     * Отчёт Источники -> Сводка.

     */
    sourcesSummary("/stat/v1/data?present=sources_summary"),

    /**

     * Отчёт Источники -> Поисковые фразы.

     */

    sourcesPhrases("/stat/v1/data?present=sources_search_phrases"),



    /**

     * Отчёт Источники -> Рекламные системы.


     */

    sourcesMarketing("/stat/v1/data?present=adv_engine"),

    /**

     * Отчёт Источники -> Директ -> сводка.

     *

     * https://tech.yandex.ru/metrika/doc/api2/api_v1/presets/preset_direct-docpage/

     */

    sourcesDirectSummary("/stat/v1/data?present=sources_direct_summary"),



    /**

     * Отчёт Источники -> Директ -> площадки.

     */

    sourcesDirectPlatforms("/stat/v1/data?present=sources_direct_platforms"),


    /**

     * Отчёт Содержание -> Страницы входа.

     *

     * https://tech.yandex.ru/metrika/doc/api2/api_v1/presets/preset_content-docpage/

     */

    contentEntrance("/stat/v1/data?present=content_entrance"),



    /**

     * Отчёт Содержание -> Страницы выхода.

      href="http://api.yandex.ru/metrika/doc/ref/stat/content-exit.xml">Справочник API</a>

     */

    contentExit("/stat/v1/data?present=content_exit"),



    /**

     * Отчёт Содержание -> Заголовки.


     */

    contentTitles("/stat/v1/data?present=titles"),



    /**

     * Отчёт Содержание -> Параметры URL.


     */

    contentUrlParam("/stat/v1/data?present=url_params"),


    /**

     * Отчет Компьютеры -> браузеры

     *

     * https://tech.yandex.ru/metrika/doc/api2/api_v1/presets/preset_tech-docpage/

     */

    techBrowsers("/stat/v1/data?present=tech_browsers"),



    /**

     * Отчет Компьютеры -> Операционные системы


     */

    techOs("/stat/v1/data?present=tech_platforms"),



    /**

     * Отчет Компьютеры -> Разрешения дисплеев

     */

    techDisplay("/stat/v1/data?present=tech_display");

    public final String url;



    Reports(String url) {

        this.url = url;

    }
}
