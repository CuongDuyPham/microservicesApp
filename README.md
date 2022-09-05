# microservicesApp
1. Run RegisterService App to start Eureka Server on port 8761.
2. Run CloudGateway App (Eureka client, port 9191) to enable Hystrix, TurbinStream, DiscoveryClient
3. Run CategoryService (port 9002) and ProductService (port 9001) App with enabled Hystrix and TurbinStream.
4. Run HystrixDashboard (Eureka client) to enable Hystrix Dashboard.
5. Open HystrixDashboard on port 9295 with url: /hystrix/ to track service apps' activities.
6. Monitor api status from CategoryService and ProductService by entering their url into Hystrix Dashboard with prefix: localhost:port/actuator/hystrix.stream/...
