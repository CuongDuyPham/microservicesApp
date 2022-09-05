# microservicesApp
1. Run RegisterService App to start Eureka Server on port 8761.
2. Run CloudGateway App (Eureka client) to enable Hystrix, TurbinStream, DiscoveryClient
3. Run CategoryService and ProductService and enable Hystrix and TurbinStream.
4. Run HystrixDashboard (Eureka client) to enable Hystrix Dashboard.
5. Run cloud gateway on port 9191 with url: /actuator/hystrix.stream
