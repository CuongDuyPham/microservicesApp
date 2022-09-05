# microservicesApp
1. Run RegisterService App to start Eureka Server on port 8761.
2. Run CloudGateway App (Eureka client) to enable Hystrix, TurbinStream, DiscoveryClient
3. Run CategoryService (port 9002) and ProductService (port 9001) App with enabled Hystrix and TurbinStream.
4. Run HystrixDashboard (Eureka client) to enable Hystrix Dashboard.
5. Open cloud gateway on port 9191 with url: /actuator/hystrix.stream to test data.
6. Open HystrixDashboard on port 9295 with url: /hystrix/
7. Monitor api status from CategoryService and ProductService by enter their url into Hystrix Dashboard with prefix: localhost:port/actuator/hystrix.stream/...
