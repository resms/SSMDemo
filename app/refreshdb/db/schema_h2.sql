DROP TABLE IF EXISTS `t_user`;
CREATE TABLE IF NOT EXISTS `t_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_name` varchar(40) NOT NULL,
  `password` varchar(32) NOT NULL,
  `age` int(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `role_name` varchar(40) NOT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_role_locale`;
CREATE TABLE `t_role_locale` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `locale` varchar(5) NOT NULL,
                        `role_name` varchar(255),
                        PRIMARY KEY (`id`,`locale`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `permission_name` varchar(40) NOT NULL,
                        `permission_value` varchar(255) NOT NULL,
                        `group_name` varchar(40),
                        `rank` varchar(255),
                        `disable` smallint default 0,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_permission_locale`;
CREATE TABLE `t_permission_locale` (
                              `id` bigint NOT NULL AUTO_INCREMENT,
                              `locale` varchar(5) NOT NULL,
                              `permission_name` varchar(255) NOT NULL,
                              PRIMARY KEY (`id`,`locale`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
                        `role_id` bigint,
                        `permission_id` bigint,
                        PRIMARY KEY (`role_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_role_user`;
CREATE TABLE `t_role_user` (
                                   `role_id` bigint,
                                   `user_id` bigint,
                                   PRIMARY KEY (`role_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;