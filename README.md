# jesper_seckill
基于Springboot商品秒杀系统

## 优化前压力测试

1、模拟同一个用户10000个线程同时访问商品列表页面，每秒完成423次请求
![首页](https://github.com/zaiyunduan123/jesper_seckill/blob/master/src/main/resources/static/img/stress-test/goodslist_test_1.png)
![首页](https://github.com/zaiyunduan123/jesper_seckill/blob/master/src/main/resources/static/img/stress-test/goodsList_test_2.png)
![首页](https://github.com/zaiyunduan123/jesper_seckill/blob/master/src/main/resources/static/img/stress-test/goodsList_test_3.png)

2、模拟同一个用户10000个线程同时访问用户信息页面，每秒完成844次请求
![首页](https://github.com/zaiyunduan123/jesper_seckill/blob/master/src/main/resources/static/img/stress-test/userinfo_test_2.png)
![首页](https://github.com/zaiyunduan123/jesper_seckill/blob/master/src/main/resources/static/img/stress-test/userinfo_test_1.png)

3、模拟多个用户10000个线程同时访问用户信息页面，每秒完成1576次请求
![首页](https://github.com/zaiyunduan123/jesper_seckill/blob/master/src/main/resources/static/img/stress-test/userinfo_test_4.png)
![首页](https://github.com/zaiyunduan123/jesper_seckill/blob/master/src/main/resources/static/img/stress-test/userinfo_test_5.png)

4、redis压力测试，每秒完成45703次SET操作，每秒完成49850次GET操作
![首页](https://github.com/zaiyunduan123/jesper_seckill/blob/master/src/main/resources/static/img/stress-test/redist_test_1.png)
