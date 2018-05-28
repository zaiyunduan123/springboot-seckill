# jesper_seckill
基于Springboot商品秒杀系统

## 优化前压力测试

### 1、模拟同一个用户同时开启1000个线程循环10次访问商品列表页面，QPS=423
![首页](https://github.com/zaiyunduan123/jesper_seckill/blob/master/src/main/resources/static/img/stress-test/goodslist_test_1.png)
![首页](https://github.com/zaiyunduan123/jesper_seckill/blob/master/src/main/resources/static/img/stress-test/goodsList_test_2.png)
![首页](https://github.com/zaiyunduan123/jesper_seckill/blob/master/src/main/resources/static/img/stress-test/goodsList_test_3.png)

### 2、模拟同一个用户同时开启1000个线程循环10次访问用户信息页面，QPS=844
![首页](https://github.com/zaiyunduan123/jesper_seckill/blob/master/src/main/resources/static/img/stress-test/userinfo_test_2.png)
![首页](https://github.com/zaiyunduan123/jesper_seckill/blob/master/src/main/resources/static/img/stress-test/userinfo_test_1.png)

### 3、模拟多个用户同时开启1000个线程循环10次访问用户信息页面，QPS=1576
![首页](https://github.com/zaiyunduan123/jesper_seckill/blob/master/src/main/resources/static/img/stress-test/userinfo_test_4.png)
![首页](https://github.com/zaiyunduan123/jesper_seckill/blob/master/src/main/resources/static/img/stress-test/userinfo_test_5.png)

### 4、redis压力测试，SET操作QPS=45703，GET操作QPS=49850
![首页](https://github.com/zaiyunduan123/jesper_seckill/blob/master/src/main/resources/static/img/stress-test/redist_test_1.png)
