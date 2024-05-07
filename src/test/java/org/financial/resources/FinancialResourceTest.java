package org.financial.resources;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

@QuarkusTest
public class FinancialResourceTest {
    @Test
    public void testCreateValidSymbol() {
        given()
                .contentType("text/plain")
                .body("AAPL")
                .when()
                .post("/stock")
                .then()
                .statusCode(200);
    }

    @Test
    public void testCreateSymbolNotFound() {
        given()
                .contentType("text/plain")
                .body("INVALID")
                .when()
                .post("/stock")
                .then()
                .statusCode(404);
    }

    @Test
    public void testGetStockMarketActions() {
        given()
                .when()
                .get("/stock/list")
                .then()
                .statusCode(Response.Status.OK.getStatusCode());
    }
}
