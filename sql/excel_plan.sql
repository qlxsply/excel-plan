CREATE TABLE "area" (
  "area_code" varchar(32) NOT NULL COMMENT '地区编码',
  "parent_area_code" varchar(32) DEFAULT NULL COMMENT '父级地区编码',
  "area_name" varchar(32) DEFAULT NULL COMMENT '地区名称',
  PRIMARY KEY ("area_code")
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='地区表';


CREATE TABLE "goods" (
  "id" int(10) NOT NULL COMMENT 'ID',
  "good_code" varchar(32) DEFAULT NULL COMMENT '商品编码',
  "good_name" varchar(32) DEFAULT NULL COMMENT '商品名称',
  "sale_user" int(11) DEFAULT NULL COMMENT '卖方',
  "category_1" varchar(32) DEFAULT NULL COMMENT '一级类目',
  "category_2" varchar(32) DEFAULT NULL COMMENT '二级类目',
  "category_3" varchar(32) DEFAULT NULL COMMENT '三级类目',
  "price" decimal(10,2) DEFAULT NULL COMMENT '商品单价',
  "quantity" int(10) DEFAULT NULL COMMENT '商品数量',
  "unit_code" varchar(32) DEFAULT NULL COMMENT '数量单位',
  PRIMARY KEY ("id")
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品表';

CREATE TABLE "order" (
  "id" int(11) NOT NULL COMMENT '主键',
  "order_code" varchar(32) DEFAULT NULL COMMENT '订单号',
  "order_type" varchar(32) DEFAULT NULL COMMENT '订单类型',
  "buy_user" int(11) DEFAULT NULL COMMENT '买方',
  "pay_type" varchar(32) DEFAULT NULL COMMENT '支付方式',
  "pay_status" varchar(255) DEFAULT NULL COMMENT '支付状态',
  "amount" decimal(32,10) DEFAULT NULL COMMENT '订单金额',
  "order_status" varchar(32) DEFAULT NULL COMMENT '订单状态',
  "create_time" datetime DEFAULT NULL COMMENT '创建时间',
  "pay_time" datetime DEFAULT NULL COMMENT '支付时间',
  PRIMARY KEY ("id")
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';

CREATE TABLE "sys_dict" (
  "id" int(11) NOT NULL AUTO_INCREMENT,
  "parent_id" int(10) NOT NULL DEFAULT '0' COMMENT '父ID，根节点的父ID为0',
  "dict_group" varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '字典分组，用于区分不同的字典记录',
  "dict_code" varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '编码，同一组字典记录内，编码不应该重复',
  "dict_type" varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '类型，S:字符 B:布尔 I:整数',
  "dict_desc" varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '描述',
  "seq" int(10) DEFAULT NULL COMMENT '序号，用于同一组字典记录的排序',
  PRIMARY KEY ("id"),
  KEY "group" ("dict_group") USING BTREE COMMENT '字典分组'
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb4 COMMENT='系统字典表';

CREATE TABLE "testc" (
  "id" int(11) NOT NULL,
  "c_bigint" bigint(255) DEFAULT NULL,
  "c_binary" binary(255) DEFAULT NULL,
  "c_bit" bit(1) DEFAULT NULL,
  "c_blob" blob,
  "c_char" char(10) DEFAULT NULL,
  "c_date" date DEFAULT NULL,
  "c_datetime" datetime DEFAULT NULL,
  "c_tinyint" tinyint(4) DEFAULT NULL,
  "c_varbinary" varbinary(255) DEFAULT NULL,
  "c_timestamp" timestamp NULL DEFAULT NULL,
  "c_varchar" varchar(12) DEFAULT NULL,
  "c_tinytext" tinytext,
  "c_tinyblob" tinyblob,
  "c_double" double DEFAULT NULL,
  "c_decimal" decimal(22,2) DEFAULT NULL,
  "c-float" float DEFAULT NULL,
  PRIMARY KEY ("id")
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE "user" (
  "id" int(11) NOT NULL,
  "user_name" varchar(32) DEFAULT NULL COMMENT '用户名称',
  "user_type" varchar(32) DEFAULT NULL COMMENT '用户类型',
  PRIMARY KEY ("id")
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';




