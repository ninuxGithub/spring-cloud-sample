#### cloud-eureka-server：
	提供核心服务的 发现启动的服务，并且注册服务， cloud-eureka-server是spring-cloud 的核心
#### cloud-eureka-client:
	提供服务的功能， web server 的业务逻辑，要创建多个client可以修改server-port 然后再启动
#### cloud-server-feign：
	承担路由器的功能, http://localhost:8765/hi?name=forezp
#### cloud-server-ribbon：
	承担路由器的功能, http://localhost:8764/hi?name=forezp

	路由的切换： 将cloud-eureka-client 在端口8762和8763启动， 当访问http://localhost:8764/hi?name=forezp 或者
	http://localhost:8764/hi?name=forezp的时候会在这两个应用之前切换， 而且是均匀的切换
#### cloud-hystrix-feign
#### cloud-hystrix-ribbon
	这连个项目都是熔断， 访问http://localhost:8764/hystrix,或者http://localhost:8765/hystrix
	输入http://localhost:8764/hystrix.stream 
	当你再次访问地址：http://localhost:8764/hi?name=forezp 的时候在监控界面就回出现service情况
	
#### cloud-zuul-server
	filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下： 
	pre：路由之前
	routing：路由之时
	post： 路由之后
	error：发送错误调用
	filterOrder：过滤的顺序
	shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
	run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
	这时访问：http://localhost:8769/api-a/hi?name=forezp ；网页显示：
	
	token is empty
	访问 http://localhost:8769/api-a/hi?name=forezp&token=22 ； 
	
	
### cloud-config-server
	启动程序：访问http://localhost:8888/foo/dev
### cloud-config-client
	打开网址访问：http://localhost:8881/hi，网页显示：foo version 2 , 显示的内容是https://github.com/ninuxGithub/SpringcloudConfig/blob/master/respo/config-client-dev.properties
	里面对应的foo
	
###	eureka-server
	cloud-config-server,  cloud-config-client 是一起的
	
	修改后的cloud-config-server,  cloud-config-client 需要加入@EnableEurekaClient
	eureka-server需要加入@EnableEurekaServer

	


