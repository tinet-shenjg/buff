<p align="center">
 <img src="https://img.shields.io/badge/Avue-1.5.4-green.svg" alt="Build Status">
  <img src="https://img.shields.io/badge/Spring%20Cloud-Finchley-orange.svg" alt="Coverage Status">
  <img src="https://img.shields.io/badge/Spring%20Boot-2.0.2-blue.svg" alt="Downloads">
  <img src="https://img.shields.io/npm/v/npm.svg" alt="Version">
  <img src="https://img.shields.io/npm/l/vue.svg" alt="License">
</p>  

# buff Microservice Architecture  
---
**基于Spring Cloud、OAuth2.0、Vue的前后端分离的权限管理系统**  
 
  
#### 基础服务开发只需要关注base base-pi 即可    
 

 ### 模块说明
``` lua
buff
├── buff-auth -- 授权服务模块  (开发ing)
├── buff-auth-api -- 授权服务提供接口(开发ing)
├── buff-base -- 系统公共服务模块
├── buff-base-api -- 系统公共服务模块接口 
├── buff-config -- 配置中心
├── buff-eureka -- 服务注册与发现
├── buff-gateway -- ZUUL网关
├── buff-core -- 公共的类文件和工具
├── buff-admin -- 与前台对接服务
```
### 功能列表(开发ing)
- 完善登录：账号密码模式、短信验证码模式、社交账号模式均整合Spring security oAuth
- 单点登录：基于Srping security oAuth 提供单点登录接口，方便其他系统对接
- 用户管理：用户是系统操作者，该功能主要完成系统用户配置。
- 机构管理：配置系统组织机构，树结构展现，可随意调整上下级。
- 菜单管理：配置系统菜单，操作权限，按钮权限标识等。
- 角色管理：角色菜单权限分配、设置角色按机构进行数据范围权限划分。
- 终端管理：动态配置oauth终端，后端可配置化。
- 字典管理：对系统中经常使用的一些较为固定的数据进行维护，如：是否等。
- 操作日志：系统正常操作日志记录和查询；系统异常信息日志记录和查询。
- 消息总线：配置动态实时刷新
- 数据权限: 使用mybatis对原查询做增强，业务代码不用控制，即可实现。
- 文件系统: 支持七牛云，扩展API几行代码实现上传下载
- 消息中心：短信、邮件模板发送，几行代码实现发送
- 聚合文档：基于zuul实现 swagger各个模块的实现
