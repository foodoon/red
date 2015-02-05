/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : red

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2015-02-05 16:06:09
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `taobao_seller_id` bigint(20) NOT NULL,
  `amount` bigint(20) NOT NULL,
  `freeze` bigint(20) NOT NULL,
  `gmt_modified` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', '1', '0', '0', '2014-12-27 23:38:35');
INSERT INTO `account` VALUES ('2', '2', '100', '0', '2014-12-27 23:38:45');
INSERT INTO `account` VALUES ('3', '3', '1500', '0', '2014-12-28 00:22:36');
INSERT INTO `account` VALUES ('4', '4', '97968', '2032', '2014-12-27 23:39:07');

-- ----------------------------
-- Table structure for `account_detail`
-- ----------------------------
DROP TABLE IF EXISTS `account_detail`;
CREATE TABLE `account_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_id` bigint(20) NOT NULL,
  `direction` int(11) NOT NULL,
  `amount` bigint(20) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `task_id` bigint(20) DEFAULT NULL,
  `account_from` bigint(20) DEFAULT NULL,
  `gmt_created` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account_detail
-- ----------------------------
INSERT INTO `account_detail` VALUES ('1', '3', '1', '500', null, '1', '4', '2014-12-28 00:23:40');
INSERT INTO `account_detail` VALUES ('2', '3', '1', '1000', null, '2', '4', '2014-12-28 00:23:44');
INSERT INTO `account_detail` VALUES ('3', '4', '3', '2032', null, '3', '4', '2014-12-29 12:44:10');

-- ----------------------------
-- Table structure for `msg_out`
-- ----------------------------
DROP TABLE IF EXISTS `msg_out`;
CREATE TABLE `msg_out` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `taobao_seller_id` bigint(20) NOT NULL,
  `msg_text` text NOT NULL,
  `recv` varchar(16) NOT NULL,
  `status` int(11) DEFAULT NULL,
  `gmt_create` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of msg_out
-- ----------------------------

-- ----------------------------
-- Table structure for `order_info`
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `taobao_seller_id` bigint(20) NOT NULL,
  `fee` bigint(20) NOT NULL,
  `status` int(11) NOT NULL,
  `gmt_created` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES ('1', '1', '1000', '0', '2015-02-05 15:40:02', '2015-02-05 15:40:02');
INSERT INTO `order_info` VALUES ('2', '1', '1000', '0', '2015-02-05 15:44:41', '2015-02-05 15:44:41');
INSERT INTO `order_info` VALUES ('3', '1', '10000', '0', '2015-02-05 16:05:19', '2015-02-05 16:05:19');
INSERT INTO `order_info` VALUES ('4', '1', '1000', '0', '2015-02-05 16:05:52', '2015-02-05 16:05:52');

-- ----------------------------
-- Table structure for `taobao_buyer`
-- ----------------------------
DROP TABLE IF EXISTS `taobao_buyer`;
CREATE TABLE `taobao_buyer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `taobao_user_id` varchar(32) DEFAULT NULL,
  `taobao_nick` varchar(64) DEFAULT NULL,
  `taobao_seller_id` bigint(20) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `phone` varchar(16) DEFAULT NULL,
  `address` varchar(1024) DEFAULT NULL,
  `gmt_created` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of taobao_buyer
-- ----------------------------
INSERT INTO `taobao_buyer` VALUES ('1', null, '测试昵称', '1', null, '17098158159', null, '2015-02-04 14:24:49');

-- ----------------------------
-- Table structure for `taobao_item`
-- ----------------------------
DROP TABLE IF EXISTS `taobao_item`;
CREATE TABLE `taobao_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `taobao_user_id` varchar(64) NOT NULL,
  `cid` bigint(20) DEFAULT NULL,
  `seller_cids` varchar(64) DEFAULT NULL,
  `pic_url` varchar(512) DEFAULT NULL,
  `item_url` varchar(1024) DEFAULT NULL,
  `num` bigint(20) DEFAULT NULL,
  `list_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `delist_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `price` bigint(20) DEFAULT NULL,
  `has_discount` int(11) DEFAULT NULL,
  `has_showcase` int(11) DEFAULT NULL,
  `approve_status` varchar(32) DEFAULT NULL,
  `is_virtual` int(11) DEFAULT NULL,
  `num_iid` bigint(20) DEFAULT NULL,
  `title` varchar(256) DEFAULT NULL,
  `nick` varchar(64) DEFAULT NULL,
  `type` varchar(16) DEFAULT NULL,
  `valid_thru` bigint(20) DEFAULT NULL,
  `sold_quantity` bigint(20) DEFAULT NULL,
  `violation` int(11) DEFAULT NULL COMMENT '是否违规',
  `gmt_created` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of taobao_item
-- ----------------------------
INSERT INTO `taobao_item` VALUES ('1', '12123', null, null, 'http://gi1.md.alicdn.com/imgextra/i1/2020696429/TB2QhNOaVXXXXXoXpXXXXXXXXXX_!!2020696429.jpg_430x430q90.jpg', null, '11', '2014-12-27 18:59:21', '2014-12-27 18:59:21', '212', null, '1', null, '1', '111', '测试商品1', null, 'b', null, '111', '0', '2014-12-27 18:59:21');
INSERT INTO `taobao_item` VALUES ('2', '12123', null, null, 'http://gi1.md.alicdn.com/imgextra/i1/2020696429/TB2QhNOaVXXXXXoXpXXXXXXXXXX_!!2020696429.jpg_430x430q90.jpg', null, '11', '2014-12-27 18:59:19', '2014-12-27 18:59:19', '232', null, '0', null, '0', null, '测试商品223', null, null, null, '33', '0', '2014-12-27 18:59:19');
INSERT INTO `taobao_item` VALUES ('4', '12123', null, null, 'http://gi4.md.alicdn.com/imgextra/i4/201688881/T23RH_XdRbXXXXXXXX_!!201688881.jpg_430x430q90.jpg', 'http://detail.tmall.com/item.htm?id=16845097999&spm=a220o.1000855.w4023-6694578511.34.eWEQpw', null, '2014-12-29 10:34:33', '2014-12-29 10:34:33', '340000', null, null, null, null, null, '测试商品343', null, null, null, null, null, '2014-12-29 10:34:33');

-- ----------------------------
-- Table structure for `taobao_order`
-- ----------------------------
DROP TABLE IF EXISTS `taobao_order`;
CREATE TABLE `taobao_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `taobao_user_id` varchar(32) NOT NULL,
  `seller_nick` varchar(32) DEFAULT NULL,
  `pic_path` varchar(512) DEFAULT NULL,
  `payment` varchar(32) DEFAULT NULL,
  `receiver_name` varchar(16) DEFAULT NULL,
  `receiver_state` varchar(16) DEFAULT NULL,
  `receiver_address` varchar(256) DEFAULT NULL,
  `receiver_zip` varchar(16) DEFAULT NULL,
  `receiver_mobile` varchar(16) DEFAULT NULL,
  `receiver_phone` varchar(16) DEFAULT NULL,
  `consign_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `received_payment` varchar(32) DEFAULT NULL,
  `tid` bigint(20) DEFAULT NULL,
  `num` bigint(20) DEFAULT NULL,
  `num_iid` bigint(20) DEFAULT NULL,
  `status` varchar(32) DEFAULT NULL,
  `type` varchar(32) DEFAULT NULL,
  `price` varchar(32) DEFAULT NULL,
  `discount_fee` varchar(32) DEFAULT NULL,
  `point_fee` bigint(20) DEFAULT NULL,
  `total_fee` varchar(32) DEFAULT NULL,
  `created` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `pay_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `modified` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `end_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `alipay_id` bigint(20) DEFAULT NULL,
  `alipay_no` varchar(255) DEFAULT NULL,
  `gmt_created` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of taobao_order
-- ----------------------------

-- ----------------------------
-- Table structure for `taobao_seller`
-- ----------------------------
DROP TABLE IF EXISTS `taobao_seller`;
CREATE TABLE `taobao_seller` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `taobao_user_id` varchar(32) DEFAULT NULL,
  `nick` varchar(32) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `level` bigint(20) DEFAULT NULL,
  `score` bigint(20) DEFAULT NULL,
  `total_num` bigint(20) DEFAULT NULL,
  `good_num` bigint(20) DEFAULT NULL,
  `type` varchar(4) DEFAULT NULL,
  `promoted_type` varchar(16) DEFAULT NULL,
  `status` varchar(16) DEFAULT NULL,
  `consumer_protection` int(11) DEFAULT NULL,
  `is_golden_seller` int(11) DEFAULT NULL,
  `gmt_created` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of taobao_seller
-- ----------------------------
INSERT INTO `taobao_seller` VALUES ('1', '1', 'test', null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `taobao_shop`
-- ----------------------------
DROP TABLE IF EXISTS `taobao_shop`;
CREATE TABLE `taobao_shop` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `taobao_user_id` varchar(32) NOT NULL,
  `sid` bigint(20) DEFAULT NULL,
  `shop_url` varchar(256) DEFAULT NULL,
  `cid` bigint(20) DEFAULT NULL,
  `nick` varchar(32) DEFAULT NULL,
  `title` varchar(64) DEFAULT NULL,
  `descript` varchar(512) DEFAULT NULL,
  `created` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `item_score` varchar(32) DEFAULT NULL,
  `service_score` varchar(32) DEFAULT NULL,
  `delivery_score` varchar(32) DEFAULT NULL,
  `gmt_created` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of taobao_shop
-- ----------------------------

-- ----------------------------
-- Table structure for `taobao_shop_cat`
-- ----------------------------
DROP TABLE IF EXISTS `taobao_shop_cat`;
CREATE TABLE `taobao_shop_cat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shop_sid` bigint(20) NOT NULL,
  `cid` bigint(20) NOT NULL,
  `parent_cid` bigint(20) NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  `is_parent` int(11) DEFAULT NULL,
  `gmt_created` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of taobao_shop_cat
-- ----------------------------

-- ----------------------------
-- Table structure for `taobao_token`
-- ----------------------------
DROP TABLE IF EXISTS `taobao_token`;
CREATE TABLE `taobao_token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `taobao_user_id` varchar(32) NOT NULL,
  `taobao_user_nick` varchar(32) DEFAULT NULL,
  `token_type` varchar(16) DEFAULT NULL,
  `access_token` varchar(64) DEFAULT NULL,
  `expires_in` bigint(20) DEFAULT NULL,
  `r1_expires_in` bigint(20) DEFAULT NULL,
  `r2_expires_in` bigint(20) DEFAULT NULL,
  `w1_expires_in` bigint(20) DEFAULT NULL,
  `w2_expires_in` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of taobao_token
-- ----------------------------

-- ----------------------------
-- Table structure for `template`
-- ----------------------------
DROP TABLE IF EXISTS `template`;
CREATE TABLE `template` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `taobao_seller_id` bigint(20) NOT NULL,
  `template_name` varchar(128) NOT NULL,
  `template_text` text NOT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of template
-- ----------------------------
INSERT INTO `template` VALUES ('1', '1', '发货提醒', '亲爱的{#收件人姓名#}，您的宝贝已发货，快递：{#快递公司#}：{#快递单号#}，请注意查收，有问题请联系【{#店铺名称#}】', null);
INSERT INTO `template` VALUES ('2', '1', '签收提醒', '亲，感谢您在{#店铺名称#}购买宝贝，签收后请仔细检查宝贝，如满意请点亮5颗星星，有问题随时联系【{#店铺名称#}】', null);
