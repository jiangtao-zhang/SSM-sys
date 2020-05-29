prompt PL/SQL Developer import file
prompt Created on 2020年5月29日 by jiangtao  zhang
set feedback off
set define off
prompt Loading MEMBER...
insert into MEMBER (id, name, nickname, phonenum, email)
values ('E61D65F673D54F68B0861025C69773DB', '张三', '小三', '18888888888', 'zs@163.com');
commit;
prompt 1 records loaded
prompt Loading PRODUCT...
insert into PRODUCT (id, productnum, productname, cityname, departuretime, productprice, productdesc, productstatus)
values ('7A757A7492F74A16884C7FB9D75AC49F', 'itcast-003', '牵头', '牵头', to_timestamp('08-04-2020 06:10:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 100000, '牵头', 0);
insert into PRODUCT (id, productnum, productname, cityname, departuretime, productprice, productdesc, productstatus)
values ('12B7ABF2A4C544568B0A7C69F36BF8B7', 'itcast-003', '上海五日游', '上海', to_timestamp('25-04-2018 14:30:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 1800, '魔都我来了', 0);
insert into PRODUCT (id, productnum, productname, cityname, departuretime, productprice, productdesc, productstatus)
values ('9F71F01CB448476DAFB309AA6DF9497F', 'itcast-001', '北京三日游', '北京', to_timestamp('10-10-2018 10:10:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 1200, '不错的旅行', 1);
insert into PRODUCT (id, productnum, productname, cityname, departuretime, productprice, productdesc, productstatus)
values ('676C5BD1D35E429A8C2E114939C5685A', 'itcast-002', '北京三日游', '北京', to_timestamp('10-10-2018 10:10:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 1200, '不错的旅行', 1);
commit;
prompt 4 records loaded
prompt Loading ORDERS...
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('0E7231DC797C486290E8713CA3C6ECCC', '12345', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, '676C5BD1D35E429A8C2E114939C5685A', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('5DC6A48DD4E94592AE904930EA866AFA', '54321', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, '676C5BD1D35E429A8C2E114939C5685A', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('2FF351C4AC744E2092DCF08CFD314420', '67890', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, '12B7ABF2A4C544568B0A7C69F36BF8B7', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('A0657832D93E4B10AE88A2D4B70B1A28', '98765', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, '12B7ABF2A4C544568B0A7C69F36BF8B7', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('E4DD4C45EED84870ABA83574A801083E', '11111', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, '12B7ABF2A4C544568B0A7C69F36BF8B7', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('96CC8BD43C734CC2ACBFF09501B4DD5D', '22222', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, '12B7ABF2A4C544568B0A7C69F36BF8B7', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('55F9AF582D5A4DB28FB4EC3199385762', '33333', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, '9F71F01CB448476DAFB309AA6DF9497F', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('CA005CF1BE3C4EF68F88ABC7DF30E976', '44444', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, '9F71F01CB448476DAFB309AA6DF9497F', 'E61D65F673D54F68B0861025C69773DB');
insert into ORDERS (id, ordernum, ordertime, peoplecount, orderdesc, paytype, orderstatus, productid, memberid)
values ('3081770BC3984EF092D9E99760FDABDE', '55555', to_timestamp('02-03-2018 12:00:00.000000', 'dd-mm-yyyy hh24:mi:ss.ff'), 2, '没什么', 0, 1, '9F71F01CB448476DAFB309AA6DF9497F', 'E61D65F673D54F68B0861025C69773DB');
commit;
prompt 9 records loaded
prompt Loading TRAVELLER...
insert into TRAVELLER (id, name, sex, phonenum, credentialstype, credentialsnum, travellertype)
values ('3FE27DF2A4E44A6DBC5D0FE4651D3D3E', '张龙', '男', '13333333333', 0, '123456789009876543', 0);
insert into TRAVELLER (id, name, sex, phonenum, credentialstype, credentialsnum, travellertype)
values ('EE7A71FB6945483FBF91543DBE851960', '张小龙', '男', '15555555555', 0, '987654321123456789', 1);
commit;
prompt 2 records loaded
prompt Loading ORDER_TRAVELLER...
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('0E7231DC797C486290E8713CA3C6ECCC', '3FE27DF2A4E44A6DBC5D0FE4651D3D3E');
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('0E7231DC797C486290E8713CA3C6ECCC', 'EE7A71FB6945483FBF91543DBE851960');
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('2FF351C4AC744E2092DCF08CFD314420', '3FE27DF2A4E44A6DBC5D0FE4651D3D3E');
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('3081770BC3984EF092D9E99760FDABDE', 'EE7A71FB6945483FBF91543DBE851960');
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('55F9AF582D5A4DB28FB4EC3199385762', 'EE7A71FB6945483FBF91543DBE851960');
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('5DC6A48DD4E94592AE904930EA866AFA', '3FE27DF2A4E44A6DBC5D0FE4651D3D3E');
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('96CC8BD43C734CC2ACBFF09501B4DD5D', 'EE7A71FB6945483FBF91543DBE851960');
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('A0657832D93E4B10AE88A2D4B70B1A28', '3FE27DF2A4E44A6DBC5D0FE4651D3D3E');
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('CA005CF1BE3C4EF68F88ABC7DF30E976', 'EE7A71FB6945483FBF91543DBE851960');
insert into ORDER_TRAVELLER (orderid, travellerid)
values ('E4DD4C45EED84870ABA83574A801083E', 'EE7A71FB6945483FBF91543DBE851960');
commit;
prompt 10 records loaded
prompt Loading PERMISSION...
insert into PERMISSION (id, permissionname, url)
values ('04B70DD3E9D44B4DA50F1208FA655CD1', 'user findAll', '/user/findAll.do');
insert into PERMISSION (id, permissionname, url)
values ('6749BF201BED4755A43AE91F961023B9', 'user findById', '/user/findById.do');
insert into PERMISSION (id, permissionname, url)
values ('5C0E4C549E07483F904E2DA5429013E0', 'role find', '/role/findAll.do');
commit;
prompt 3 records loaded
prompt Loading ROLE...
insert into ROLE (id, rolename, roledesc)
values ('1111', 'ADMIN', 'VIP');
insert into ROLE (id, rolename, roledesc)
values ('2222', 'USER', 'VIP');
commit;
prompt 2 records loaded
prompt Loading ROLE_PERMISSION...
insert into ROLE_PERMISSION (permissionid, roleid)
values ('04B70DD3E9D44B4DA50F1208FA655CD1', '1111');
insert into ROLE_PERMISSION (permissionid, roleid)
values ('6749BF201BED4755A43AE91F961023B9', '1111');
insert into ROLE_PERMISSION (permissionid, roleid)
values ('6749BF201BED4755A43AE91F961023B9', '2222');
commit;
prompt 3 records loaded
prompt Loading SYSLOG...
insert into SYSLOG (id, visittime, username, ip, url, executiontime, method)
values ('1A72B18D50F745779EABA667BA78B1E9', to_timestamp('04-05-2020 21:31:17.726000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'tom', '0:0:0:0:0:0:0:1', '/userfindAll.do', 18, '[类名]com.itheima.ssm.controller.UserController[方法名]findAllUser');
insert into SYSLOG (id, visittime, username, ip, url, executiontime, method)
values ('3ACAB6E0FD2C4CF6A814D5B9711A37E7', to_timestamp('04-05-2020 21:31:23.947000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'tom', '0:0:0:0:0:0:0:1', '/userfindUserByIdAndAllRole.do', 71, '[类名]com.itheima.ssm.controller.UserController[方法名]findUserByIdAndAllRole');
insert into SYSLOG (id, visittime, username, ip, url, executiontime, method)
values ('77358970B2AC48C9BD6F0A29B9DEBCBF', to_timestamp('04-05-2020 21:31:27.308000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'tom', '0:0:0:0:0:0:0:1', '/userfindAll.do', 6, '[类名]com.itheima.ssm.controller.UserController[方法名]findAllUser');
insert into SYSLOG (id, visittime, username, ip, url, executiontime, method)
values ('6F32B90391384DF3BA7BAB0844E368B1', to_timestamp('04-05-2020 21:31:28.755000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'tom', '0:0:0:0:0:0:0:1', '/userfindUserByIdAndAllRole.do', 9, '[类名]com.itheima.ssm.controller.UserController[方法名]findUserByIdAndAllRole');
insert into SYSLOG (id, visittime, username, ip, url, executiontime, method)
values ('76DBCA5D4D484C3A9919A3E9439D04BF', to_timestamp('04-05-2020 16:43:13.917000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'tom', '0:0:0:0:0:0:0:1', '/userfindAll.do', 24, '[类名]com.itheima.ssm.controller.UserController[方法名]findAllUser');
insert into SYSLOG (id, visittime, username, ip, url, executiontime, method)
values ('ECB4359A56B141A2BB062F48A6D3CB2C', to_timestamp('04-05-2020 16:45:19.512000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'tom', '0:0:0:0:0:0:0:1', 'permissionfindAll.do', 19, '[类名]com.itheima.ssm.controller.PermissionController[方法名]findAllPermission');
insert into SYSLOG (id, visittime, username, ip, url, executiontime, method)
values ('8E74F4B93BA148AAB1080772998C3AAE', to_timestamp('04-05-2020 16:03:27.961000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'tom', '0:0:0:0:0:0:0:1', '/product/findAll.do', 154, '[类名]com.itheima.ssm.controller.ProductController[方法名]findAllProduct');
insert into SYSLOG (id, visittime, username, ip, url, executiontime, method)
values ('24B3CDB5B4E4468D9BE0866648A5DB9F', to_timestamp('04-05-2020 16:10:53.298000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'tom', '0:0:0:0:0:0:0:1', '/product/findAll.do', 58, '[类名]com.itheima.ssm.controller.ProductController[方法名]findAllProduct');
insert into SYSLOG (id, visittime, username, ip, url, executiontime, method)
values ('C5D3838BF89542548183E679A997AEA0', to_timestamp('04-05-2020 16:11:32.208000', 'dd-mm-yyyy hh24:mi:ss.ff'), 'tom', '0:0:0:0:0:0:0:1', '/orders/findAll.do', 138, '[类名]com.itheima.ssm.controller.OrderController[方法名]findall');
commit;
prompt 9 records loaded
prompt Loading USERS...
insert into USERS (id, email, username, password, phonenum, status)
values ('111-222', 'tom@itheima.cn', 'tom', '$2a$10$YpGhQt.xi1CyhQqfjA/H.uREy6EkfHUmj7BNGTUVz.ZpRIDn1Fw0q', '15235150152', 1);
insert into USERS (id, email, username, password, phonenum, status)
values ('222-222', 'tt', 'tt', 'tt', 'tt', 1);
insert into USERS (id, email, username, password, phonenum, status)
values ('99AC8B2EB0E74C2B815CFA06B9B289D2', '1317157699@qq.com', 'jiangtao', '$2a$10$xTRv6hAUIGpnSAfft5AuUOS5h4MjZQ87aV2Hz/xyPQASVkhnRuxhO', '12233333333', 1);
commit;
prompt 3 records loaded
prompt Loading USERS_ROLE...
insert into USERS_ROLE (userid, roleid)
values ('111-222', '1111');
insert into USERS_ROLE (userid, roleid)
values ('111-222', '2222');
insert into USERS_ROLE (userid, roleid)
values ('99AC8B2EB0E74C2B815CFA06B9B289D2', '2222');
commit;
prompt 3 records loaded
set feedback on
set define on
prompt Done.
