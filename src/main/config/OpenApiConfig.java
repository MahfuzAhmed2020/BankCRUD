@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI bankCrudOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Bank CRUD API")
                        .version("1.0")
                        .description("REST API for Bank CRUD operations"));
    }
}