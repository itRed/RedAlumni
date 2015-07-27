/*
SQLyog v10.2 
MySQL - 5.5.25 : Database - alumni
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`alumni` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `alumni`;

/*Table structure for table `contentinfo` */

DROP TABLE IF EXISTS `contentinfo`;

CREATE TABLE `contentinfo` (
  `CONTENT_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识',
  `CONTENT_TITLE` text COMMENT '题目',
  `CONTENT_DETAIL` text COMMENT '详细内容',
  `CONTENT_DATE` varchar(45) DEFAULT NULL COMMENT '提交时间',
  `CONTENT_USERID` int(11) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`CONTENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

/*Data for the table `contentinfo` */

insert  into `contentinfo`(`CONTENT_ID`,`CONTENT_TITLE`,`CONTENT_DETAIL`,`CONTENT_DATE`,`CONTENT_USERID`) values (34,'String realpath = request.getSession().getServletContext().getRealPath(\"/\") + \"images/pdflogo.jpg\"; list.add(new PdfImage(realpath));String realpath = request.getSession().getServletContext().getRealPath(\"/\") + \"images/pdflogo.jpg\";  list.add(new PdfImage(realpath));','<p>String realpath = request.getSession().getServletContext().getRealPath(&quot;/&quot;) + &quot;images/pdflogo.jpg&quot;;&nbsp;list.add(new PdfImage(realpath));String realpath = request.getSession().getServletContext().getRealPath(&quot;/&quot;) + &quot;images/pdflogo.jpg&quot;;&nbsp;&nbsp;list.add(new PdfImage(realpath));</p>\n','1431570592',3),(35,'﻿NoSQL数据库入门 高清PDF   ==更新链接==  http://www.linuxidc.com/Linux/2014-09/106689.htm\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n----------------------------------分割线-------------------------------------\r\n\r\n\r\n\r\nLinux公社（LinuxIDC.com）于2006年9月25日注册并开通网站，Linux现在已经成为一种广受关注和支持的一种操作系统，IDC是互联网数据中心，LinuxIDC就是关于Linux的数据中心。\r\n \r\nLinux公社是专业的Linux系统门户网站，实时发布最新Linux资讯，包括Linux、Ubuntu、Fedora、RedHat、红旗Linux、Linux教程、Linux认证、SUSE Linux、Android、Oracle、Hadoop、CentOS等技术。','<p>http://www.cnblogs.com/itred/p/4420905.htmlhttp://www.cnblogs.com/itred/p/4420905.htmlhttp://www.cnblogs.com/itred/p/4420905.htmlhttp://www.cnblogs.com/itred/p/4420905.htmlhttp://www.cnblogs.com/itred/p/4420905.htmlhttp://www.cnblogs.com/itred/p/4420905.htmlhttp://www.cnblogs.com/itred/p/4420905.html</p>\r\n','1431571013',2),(36,'学，四年之中感谢您的陪伴和支持！生命中，感谢有你！本系统将从即学，四年之中感谢您的陪伴和支持！生命中，感谢有你！本系统将从即学，四年之中感谢您的陪伴和支持！生命中，感谢有你！本系统将从即学，四年之中感谢您的陪伴和支持！生命中，感谢有你！本系统将从即学，四年之中感谢您的陪伴和支持！生命中，感谢有你！本系统将从即学，四年之中感谢您的陪伴和支持！生命中，感谢有你！本系统将从即','<p>学，<span style=\"color:rgb(255, 0, 0); font-family:幼圆; font-size:x-large\">四年之中感谢您的陪伴和支持！生命中，感谢有你！本系统将从即</span>学，<span style=\"color:rgb(255, 0, 0); font-family:幼圆; font-size:x-large\">四年之中感谢您的陪伴和支持！生命中，感谢有你！本系统将从即</span>学，<span style=\"color:rgb(255, 0, 0); font-family:幼圆; font-size:x-large\">四年之中感谢您的陪伴和支持！生命中，感谢有你！本系统将从即</span>学，<span style=\"color:rgb(255, 0, 0); font-family:幼圆; font-size:x-large\">四年之中感谢您的陪伴和支持！生命中，感谢有你！本系统将从即</span>学，<span style=\"color:rgb(255, 0, 0); font-family:幼圆; font-size:x-large\">四年之中感谢您的陪伴和支持！生命中，感谢有你！本系统将从即</span>学，<span style=\"color:rgb(255, 0, 0); font-family:幼圆; font-size:x-large\">四年之中感谢您的陪伴和支持！生命中，感谢有你！本系统将从即</span></p>\n','1431670032',3);

/*Table structure for table `roleinfo` */

DROP TABLE IF EXISTS `roleinfo`;

CREATE TABLE `roleinfo` (
  `ROLE_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色唯一标识',
  `ROLE_DES` varchar(45) DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `roleinfo` */

insert  into `roleinfo`(`ROLE_ID`,`ROLE_DES`) values (1,'管理员'),(2,'同学'),(3,'老师');

/*Table structure for table `statusinfo` */

DROP TABLE IF EXISTS `statusinfo`;

CREATE TABLE `statusinfo` (
  `STATUS_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '状态唯一标识',
  `STATUS_DES` varchar(45) DEFAULT NULL COMMENT '状态描述',
  PRIMARY KEY (`STATUS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `statusinfo` */

insert  into `statusinfo`(`STATUS_ID`,`STATUS_DES`) values (1,'从未登录'),(2,'已登录');

/*Table structure for table `userinfo` */

DROP TABLE IF EXISTS `userinfo`;

CREATE TABLE `userinfo` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识符',
  `USER_NAME` varchar(45) DEFAULT NULL COMMENT '用户名',
  `USER_ALIAS` varchar(45) DEFAULT NULL COMMENT '别名，绰号',
  `USER_PWD` varchar(45) DEFAULT NULL COMMENT '密码',
  `USER_EMAIL` varchar(45) DEFAULT NULL COMMENT '邮箱',
  `USER_BIRTH` varchar(45) DEFAULT NULL COMMENT '生日',
  `USER_HOME` varchar(45) DEFAULT NULL COMMENT '家庭住址',
  `USER_PLACE` varchar(45) DEFAULT NULL COMMENT '现居地',
  `USER_PHONE` varchar(11) DEFAULT NULL COMMENT '电话',
  `USER_QQ` varchar(45) DEFAULT NULL COMMENT 'QQ号',
  `USER_MOTTO` varchar(45) DEFAULT NULL COMMENT '座右铭',
  `USER_ROLEID` int(1) DEFAULT NULL COMMENT '角色ID',
  `USER_STATUSID` int(1) DEFAULT NULL COMMENT '状态ID',
  `USER_USER_PERMISSION` int(1) DEFAULT NULL COMMENT '权限值0/1；1禁用',
  PRIMARY KEY (`USER_ID`),
  KEY `USER_ROLEID` (`USER_ROLEID`),
  KEY `USER_STATUSID` (`USER_STATUSID`),
  CONSTRAINT `userinfo_ibfk_1` FOREIGN KEY (`USER_ROLEID`) REFERENCES `roleinfo` (`ROLE_ID`),
  CONSTRAINT `userinfo_ibfk_2` FOREIGN KEY (`USER_STATUSID`) REFERENCES `statusinfo` (`STATUS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `userinfo` */

insert  into `userinfo`(`USER_ID`,`USER_NAME`,`USER_ALIAS`,`USER_PWD`,`USER_EMAIL`,`USER_BIRTH`,`USER_HOME`,`USER_PLACE`,`USER_PHONE`,`USER_QQ`,`USER_MOTTO`,`USER_ROLEID`,`USER_STATUSID`,`USER_USER_PERMISSION`) values (1,'王兴宇','大雨哥','111111','it_red@sina.com',NULL,'上海-上海市-虹口区','上海-上海市-虹口区','13671700000','1159293','做最好的自己',1,1,0),(2,'刘俊',NULL,NULL,'it_red@sina.com',NULL,NULL,NULL,'13671700000','115929300','知识改变命运',3,1,NULL),(3,'马浩','浩哥','null','it_red@sina.com','1991-1-15','江苏省-苏州市-吴江市','北京-北京市-海淀区','13540400000','11592939','知识就是财富！',2,2,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
