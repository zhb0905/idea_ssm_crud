## 项目(demo)简介
* 使用 SSM 框架搭建一套CRUD 项目示例，包括分页查询、Ajax请求、数据校验等。

### 演示步骤
1、db.sql创建数据库 

2、MapperTest.java添加演示的数据。 ( 可自行添加其他记录 )

3、部署Tomcat，在 http://localhost:8080/ssm_crud_war/# 查看页面效果

### 主要实现的功能
1、主页查询所有员工，结果分页展示
* 显示的记录条数、分页条数可在 EmployeeController.getEmpsWithJson() 手动更改。
* 含首尾页，前后页( 可自动隐藏 )。

2、在 “添加” 按钮新增员工，在模态框中添加，需完成验证:
* jQuery 前端校验：用户名邮箱合法性。( index.jsp :  function validate_add_form() )
* Ajax 请求校验：用户名是否重复。( index.jsp :  $("#empName_add_input").change() )
* JSR 303 后端校验：用户名邮箱合法性，用户名是否重复。( EmployeeBean, EmployeeController )

3、在 “编辑” 按钮修改员工。在模态框中修改，需验证：
* 邮箱格式合法性

4、删除，批量删除(多选框)。

5、RESTful 风格的URI。


### 涉及的技术
1、后端框架：SSM（Spring 5 + Spring MVC + MyBatis 3）+ Maven 3.6.3

2、MyBatis 分页插件：PageHelper

3、MyBatis 逆向工程：MyBatis Generator

4、数据库：MySQL 8.0 , 数据库连接池 : Druid

5、前端框架：BootStrap 3

6、版本管理: Git (master、develop、feature—xxx)

