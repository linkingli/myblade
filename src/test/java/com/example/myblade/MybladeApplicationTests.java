package com.example.myblade;

import com.example.myblade.model.UserDemo;
import jetbrick.template.JetEngine;
import jetbrick.template.JetTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybladeApplicationTests {

	@Test
	public void contextLoads() {
	}
	//test JetEngine
	@Test
	public void test() {
		// 0. 准备一些 Model 数据作为测试
		List<UserDemo> users = Arrays.asList(
				new UserDemo("张三", "zhangsan@qq.com"),
				new UserDemo("李四", "lisi@qq.com"),
				new UserDemo("王五", "wangwu@qq.com")
		);

		// 1. 创建一个默认的 JetEngine
		JetEngine engine = JetEngine.create();

		// 2. 获取一个模板对象 (从默认的 classpath 下面)
		JetTemplate template = engine.getTemplate("/users.jetx");

		// 3. 创建 context 对象
		Map<String, Object> context = new HashMap<String, Object>();
		context.put("users", users);

		// 4. 渲染模板到自定义的 Writer
		StringWriter writer = new StringWriter();
		template.render(context, writer);

		// 5. 打印结果
		System.out.println(writer.toString());
	}
}
