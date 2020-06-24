package eu.mrndesign.matned.springApp.controller;

import eu.mrndesign.matned.springApp.TaskConfigurationProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class InfoController {

//    @Value("${spring.datasource.url}")
//    @Autowired

    private final DataSourceProperties datasource;
    private final TaskConfigurationProperties taskConfigurationProperties;

    InfoController(final DataSourceProperties datasource, final TaskConfigurationProperties taskConfigurationProperties) {
        this.datasource = datasource;
        this.taskConfigurationProperties = taskConfigurationProperties;
    }

    @GetMapping("/info/url")
    String url() {
        return datasource.getUrl();
    }

    @GetMapping("/info/taskPropConf")
    boolean taskConfigurationProperties() {
        return taskConfigurationProperties.getTemplate().isAllowMultipleTasks();
    }

}
