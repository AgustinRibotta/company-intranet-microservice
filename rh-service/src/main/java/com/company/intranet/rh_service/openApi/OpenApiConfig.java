package com.company.intranet.rh_service.openApi;

import com.company.intranet.rh_service.exeptions.ErrorDetails;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;


@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("User Service API").version("1.0"))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("basicAuth",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("basic"))
                        .addSecuritySchemes("bearerAuth",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .addSecurityItem(new SecurityRequirement().addList("basicAuth"));
    }

    @Bean
    public OpenApiCustomizer globalResponses() {
        return openApi -> openApi.getPaths().values().forEach(pathItem ->
                pathItem.readOperations().forEach(op -> {

                    // 204 global
                    ApiResponse response204 = new ApiResponse()
                            .description("No content")
                            .content(new Content().addMediaType("application/json",
                                    new MediaType().schema(new Schema<ErrorDetails>()
                                            .example(new ErrorDetails(
                                                    LocalDateTime.now(),
                                                    "No content",
                                                    "/api/resource"
                                            ))

                                    ))
                            );
                    op.getResponses().addApiResponse("204", response204);

                    // 400 global
                    ApiResponse response400 = new ApiResponse()
                            .description("Invalid request body")
                            .content(new Content().addMediaType("application/json",
                                    new MediaType().schema(new Schema<ErrorDetails>()
                                            .example(new ErrorDetails(
                                                    LocalDateTime.now(),
                                                    "Invalid request body",
                                                    "/api/resource"
                                            ))

                                    ))
                            );
                    op.getResponses().addApiResponse("400", response400);

                    // 403 global
                    ApiResponse response403 = new ApiResponse()
                            .description("Access denied")
                            .content(new Content().addMediaType("application/json",
                                    new MediaType().schema(new Schema<ErrorDetails>()
                                            .example(new ErrorDetails(
                                                            LocalDateTime.now(),
                                                            "Full authentication is required to access this resource",
                                                            "/api/resource"
                                                    )
                                            )
                                    ))
                            );
                    op.getResponses().addApiResponse("403", response403);

                    // 404 global
                    ApiResponse response404 = new ApiResponse()
                            .description("Resource not found")
                            .content(new Content().addMediaType("application/json",
                                    new MediaType().schema(new Schema<ErrorDetails>()
                                            .example(new ErrorDetails(
                                                            LocalDateTime.now(),
                                                            "Resource not found",
                                                            "/api/resource"
                                                    )
                                            )
                                    )
                            ));
                    op.getResponses().addApiResponse("404", response404);
                })
        );
    }

}




