/*
 Navicat Premium Data Transfer

 Source Server         : EmployeeManagement
 Source Server Type    : MySQL
 Source Server Version : 100128
 Source Host           : localhost:3306
 Source Schema         : emp_managementdb

 Target Server Type    : MySQL
 Target Server Version : 100128
 File Encoding         : 65001

 Date: 29/11/2019 11:50:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administration
-- ----------------------------
DROP TABLE IF EXISTS `administration`;
CREATE TABLE `administration`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of administration
-- ----------------------------
INSERT INTO `administration` VALUES (1, 'شئون عاملين');
INSERT INTO `administration` VALUES (2, 'انفاق و كبارى');
INSERT INTO `administration` VALUES (3, 'نظم و اتصالات');

-- ----------------------------
-- Table structure for career
-- ----------------------------
DROP TABLE IF EXISTS `career`;
CREATE TABLE `career`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `job_group_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_career_job_group_id`(`job_group_id`) USING BTREE,
  CONSTRAINT `FK_career_job_group_id` FOREIGN KEY (`job_group_id`) REFERENCES `job_group` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of career
-- ----------------------------
INSERT INTO `career` VALUES (0, NULL, 0);
INSERT INTO `career` VALUES (1, 'محاسب', 1);
INSERT INTO `career` VALUES (2, 'اخصائى نظم', 1);
INSERT INTO `career` VALUES (4, 'محامى', 1);
INSERT INTO `career` VALUES (5, 'طبيب عيون', 3);
INSERT INTO `career` VALUES (6, 'طبيب جراح', 3);
INSERT INTO `career` VALUES (7, 'مدنى', 5);
INSERT INTO `career` VALUES (8, 'معمارى', 5);
INSERT INTO `career` VALUES (9, 'فنى انشاء', 2);
INSERT INTO `career` VALUES (10, 'اخصائى اول', 1);
INSERT INTO `career` VALUES (11, 'اخصائى تانى', 1);
INSERT INTO `career` VALUES (12, 'اخصائى تالت', 1);

-- ----------------------------
-- Table structure for degree
-- ----------------------------
DROP TABLE IF EXISTS `degree`;
CREATE TABLE `degree`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of degree
-- ----------------------------
INSERT INTO `degree` VALUES (1, 'الاولى');
INSERT INTO `degree` VALUES (2, 'الثانية');
INSERT INTO `degree` VALUES (3, 'الثالثة');
INSERT INTO `degree` VALUES (4, 'الرابعة');
INSERT INTO `degree` VALUES (5, 'الخامسة');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `administration_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_department_administration_id`(`administration_id`) USING BTREE,
  CONSTRAINT `FK_department_administration_id` FOREIGN KEY (`administration_id`) REFERENCES `administration` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, 'التنظيم و التدريب', 1);
INSERT INTO `department` VALUES (2, 'الحاسب الالى', 1);
INSERT INTO `department` VALUES (3, '  حفر نفق', 2);
INSERT INTO `department` VALUES (4, 'كوبرى السعيد', 2);
INSERT INTO `department` VALUES (5, 'نظم نظمي', 3);
INSERT INTO `department` VALUES (10, 'اتصال السعيد', 3);

-- ----------------------------
-- Table structure for emp_type
-- ----------------------------
DROP TABLE IF EXISTS `emp_type`;
CREATE TABLE `emp_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of emp_type
-- ----------------------------
INSERT INTO `emp_type` VALUES (0, NULL);
INSERT INTO `emp_type` VALUES (1, 'موظف دائم');
INSERT INTO `emp_type` VALUES (2, 'موظف عقد');
INSERT INTO `emp_type` VALUES (3, 'عامل دائم');
INSERT INTO `emp_type` VALUES (4, 'عامل عقد');
INSERT INTO `emp_type` VALUES (5, 'مكافأة شاملة');
INSERT INTO `emp_type` VALUES (6, 'عقد فوق السن');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `emp_no` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type_id` int(11) NULL DEFAULT NULL,
  `graduation_date` date NULL DEFAULT NULL,
  `birth_date` date NULL DEFAULT NULL,
  `recruitment_date` date NULL DEFAULT NULL,
  `recruitment_decision_number` int(11) NULL DEFAULT NULL,
  `job_stability_date` date NULL DEFAULT NULL,
  `job_stability_decision_number` int(11) NULL DEFAULT NULL,
  `job_group_id` int(11) NULL DEFAULT NULL,
  `career_id` int(11) NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `notes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`emp_id`) USING BTREE,
  UNIQUE INDEX `FK_employee_emp_no`(`emp_no`) USING BTREE,
  INDEX `FK_employee_emp_type_id`(`type_id`) USING BTREE,
  INDEX `FK_employee_job_group_id`(`job_group_id`) USING BTREE,
  INDEX `FK_employee_career_id`(`career_id`) USING BTREE,
  CONSTRAINT `FK_employee_career_id` FOREIGN KEY (`career_id`) REFERENCES `career` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `FK_employee_emp_type_id` FOREIGN KEY (`type_id`) REFERENCES `emp_type` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `FK_employee_job_group_id` FOREIGN KEY (`job_group_id`) REFERENCES `job_group` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (23, 'shaheen', 5, '2019-11-01', '2019-11-01', '2019-11-14', 55, '2019-11-07', 55, 1, 2, 'asdfv', 'aSDFjjjjjjjjjjjjjjj', 4);
INSERT INTO `employee` VALUES (1, 'shaheen', 4, '2019-11-14', '2019-11-16', '2019-11-02', 23, '2019-11-21', 25, 5, 7, 'hhhhhhhhhhhh', 'hhhhhhhhhhhhhhh', 5);
INSERT INTO `employee` VALUES (2, 'shaheeeeeeeeeeen', 0, '2019-11-08', '2019-11-01', '2019-10-30', 4, '2019-10-31', 5, 0, 0, 'gggggggg', 'gggggggg', 6);

-- ----------------------------
-- Table structure for employee_degree
-- ----------------------------
DROP TABLE IF EXISTS `employee_degree`;
CREATE TABLE `employee_degree`  (
  `emp_id` int(11) NOT NULL,
  `degree_id` int(11) NOT NULL,
  `degree_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`emp_id`, `degree_id`) USING BTREE,
  INDEX `FK_employee_degree_dgree_id`(`degree_id`) USING BTREE,
  CONSTRAINT `FK_employee_degree_dgree_id` FOREIGN KEY (`degree_id`) REFERENCES `degree` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `FK_employee_degree_employee_emp_id` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for employee_training
-- ----------------------------
DROP TABLE IF EXISTS `employee_training`;
CREATE TABLE `employee_training`  (
  `emp_id` int(11) NOT NULL,
  `training_id` int(11) NOT NULL,
  PRIMARY KEY (`emp_id`, `training_id`) USING BTREE,
  INDEX `FK_employee_training_training_training_id`(`training_id`) USING BTREE,
  CONSTRAINT `FK_employee_training_employee_emp_id` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_employee_training_training_training_id` FOREIGN KEY (`training_id`) REFERENCES `training` (`training_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for governorate
-- ----------------------------
DROP TABLE IF EXISTS `governorate`;
CREATE TABLE `governorate`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of governorate
-- ----------------------------
INSERT INTO `governorate` VALUES (1, 'الاسماعيلية');
INSERT INTO `governorate` VALUES (2, 'السويس');
INSERT INTO `governorate` VALUES (3, 'القاهرة');
INSERT INTO `governorate` VALUES (4, 'الاسكندرية');
INSERT INTO `governorate` VALUES (5, 'بورسعيد');

-- ----------------------------
-- Table structure for higher_qualification
-- ----------------------------
DROP TABLE IF EXISTS `higher_qualification`;
CREATE TABLE `higher_qualification`  (
  `id` int(11) NOT NULL,
  `emp_id` int(11) NULL DEFAULT NULL,
  `specification_id` int(11) NULL DEFAULT NULL,
  `qualification_id` int(11) NULL DEFAULT NULL,
  `
university_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `
college_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `qualification_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_higher_qualification_specification_id`(`specification_id`) USING BTREE,
  INDEX `FK_higher_qualification_qualification_id`(`qualification_id`) USING BTREE,
  INDEX `FK_higher_qualification_employee_emp_id`(`emp_id`) USING BTREE,
  CONSTRAINT `FK_higher_qualification_employee_emp_id` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_higher_qualification_qualification_id` FOREIGN KEY (`qualification_id`) REFERENCES `qualification` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `FK_higher_qualification_specification_id` FOREIGN KEY (`specification_id`) REFERENCES `specification` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for job_group
-- ----------------------------
DROP TABLE IF EXISTS `job_group`;
CREATE TABLE `job_group`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of job_group
-- ----------------------------
INSERT INTO `job_group` VALUES (0, NULL);
INSERT INTO `job_group` VALUES (1, 'الاخصائيون');
INSERT INTO `job_group` VALUES (2, 'الفنيون');
INSERT INTO `job_group` VALUES (3, 'الاطباء');
INSERT INTO `job_group` VALUES (4, 'الصيادلة');
INSERT INTO `job_group` VALUES (5, 'مهندسين');
INSERT INTO `job_group` VALUES (6, 'قباطنه');

-- ----------------------------
-- Table structure for mandate
-- ----------------------------
DROP TABLE IF EXISTS `mandate`;
CREATE TABLE `mandate`  (
  `id` int(11) NOT NULL,
  `emp_id` int(11) NOT NULL,
  `mandate_administration_id` int(11) NULL DEFAULT NULL,
  `mandate_department_id` int(11) NULL DEFAULT NULL,
  `mandate_governorate_id` int(11) NULL DEFAULT NULL,
  `start_mandate_date` date NULL DEFAULT NULL,
  `end_mandate_date` date NULL DEFAULT NULL,
  `mandate_decision_number` int(11) NULL DEFAULT NULL,
  `mandate_decision_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_mandate_administration_id`(`mandate_administration_id`) USING BTREE,
  INDEX `FK_mandate_department_id`(`mandate_department_id`) USING BTREE,
  INDEX `FK_mandate_governorate_id`(`mandate_governorate_id`) USING BTREE,
  INDEX `FK_mandate_employee_emp_id`(`emp_id`) USING BTREE,
  CONSTRAINT `FK_mandate_administration_id` FOREIGN KEY (`mandate_administration_id`) REFERENCES `administration` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `FK_mandate_department_id` FOREIGN KEY (`mandate_department_id`) REFERENCES `department` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `FK_mandate_employee_emp_id` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_mandate_governorate_id` FOREIGN KEY (`mandate_governorate_id`) REFERENCES `governorate` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for movement
-- ----------------------------
DROP TABLE IF EXISTS `movement`;
CREATE TABLE `movement`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_id` int(11) NOT NULL,
  `governorate_id` int(11) NULL DEFAULT NULL,
  `administration_id` int(11) NULL DEFAULT NULL,
  `department_id` int(11) NULL DEFAULT NULL,
  `movement_date` date NULL DEFAULT NULL,
  `movement_decision_number` int(11) NULL DEFAULT NULL,
  `movement_decision_date` date NULL DEFAULT NULL,
  `case_type_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_movement_movement_case_type_id`(`case_type_id`) USING BTREE,
  INDEX `FK_movement_governorate_id`(`governorate_id`) USING BTREE,
  INDEX `FK_movement_department_id`(`administration_id`) USING BTREE,
  INDEX `FK_movement_employee_emp_id`(`emp_id`) USING BTREE,
  CONSTRAINT `FK_movement_administration_id` FOREIGN KEY (`administration_id`) REFERENCES `administration` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `FK_movement_department_id` FOREIGN KEY (`administration_id`) REFERENCES `department` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `FK_movement_employee_emp_id` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_movement_governorate_id` FOREIGN KEY (`governorate_id`) REFERENCES `governorate` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `FK_movement_movement_case_type_id` FOREIGN KEY (`case_type_id`) REFERENCES `movement_case_type` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for movement_case_type
-- ----------------------------
DROP TABLE IF EXISTS `movement_case_type`;
CREATE TABLE `movement_case_type`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for qualification
-- ----------------------------
DROP TABLE IF EXISTS `qualification`;
CREATE TABLE `qualification`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qualification
-- ----------------------------
INSERT INTO `qualification` VALUES (1, 'بكالوريوس نظم معلومات');
INSERT INTO `qualification` VALUES (2, 'بكالوريوس هندسه');
INSERT INTO `qualification` VALUES (3, 'بكالوريوس صيدله');
INSERT INTO `qualification` VALUES (4, 'بكالوريوس طب');

-- ----------------------------
-- Table structure for sanction
-- ----------------------------
DROP TABLE IF EXISTS `sanction`;
CREATE TABLE `sanction`  (
  `id` int(11) NOT NULL,
  `emp_id` int(11) NOT NULL,
  `sanction_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sanction_date` date NULL DEFAULT NULL,
  `sanction_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `violation_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_sanction_employee_emp_id`(`emp_id`) USING BTREE,
  CONSTRAINT `FK_sanction_employee_emp_id` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for special_vacation
-- ----------------------------
DROP TABLE IF EXISTS `special_vacation`;
CREATE TABLE `special_vacation`  (
  `id` int(11) NOT NULL,
  `emp_id` int(11) NULL DEFAULT NULL,
  `vacation_type_id` int(11) NULL DEFAULT NULL,
  `vacation_place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `vacation_duration` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `start_vacation_date` date NULL DEFAULT NULL,
  `end_vacation_date` date NULL DEFAULT NULL,
  `vacation_decision_number` int(11) NULL DEFAULT NULL,
  `vacation_decision_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_special_vacation_special_vacation_type_id`(`vacation_type_id`) USING BTREE,
  INDEX `FK_special_vacation_employee_emp_id`(`emp_id`) USING BTREE,
  CONSTRAINT `FK_special_vacation_employee_emp_id` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_special_vacation_special_vacation_type_id` FOREIGN KEY (`vacation_type_id`) REFERENCES `special_vacation_type` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for special_vacation_type
-- ----------------------------
DROP TABLE IF EXISTS `special_vacation_type`;
CREATE TABLE `special_vacation_type`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for specification
-- ----------------------------
DROP TABLE IF EXISTS `specification`;
CREATE TABLE `specification`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `qualification_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_specification_qualification_id`(`qualification_id`) USING BTREE,
  CONSTRAINT `FK_specification_qualification_id` FOREIGN KEY (`qualification_id`) REFERENCES `qualification` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of specification
-- ----------------------------
INSERT INTO `specification` VALUES (1, 'علوم حاسب', 1);
INSERT INTO `specification` VALUES (2, 'قلب ', 4);
INSERT INTO `specification` VALUES (3, 'جراحة عامة', 4);
INSERT INTO `specification` VALUES (4, 'نظم معلومات', 1);
INSERT INTO `specification` VALUES (5, 'مدنى', 2);
INSERT INTO `specification` VALUES (6, 'معمارى', 2);

-- ----------------------------
-- Table structure for training
-- ----------------------------
DROP TABLE IF EXISTS `training`;
CREATE TABLE `training`  (
  `training_id` int(11) NOT NULL AUTO_INCREMENT,
  `training_type_id` int(11) NULL DEFAULT NULL,
  `training_outlet_id` int(11) NULL DEFAULT NULL,
  `training_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `training_side` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `training_place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `start_training_date` date NULL DEFAULT NULL,
  `end_training_date` date NULL DEFAULT NULL,
  `training_fees` double(11, 0) NULL DEFAULT NULL,
  `notes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `guarantor_id` int(11) NULL DEFAULT NULL,
  `guarantor_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `training_decision_number` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`training_id`) USING BTREE,
  INDEX `FK_training_training_type_id`(`training_type_id`) USING BTREE,
  INDEX `FK_training_training_toulet_id`(`training_outlet_id`) USING BTREE,
  CONSTRAINT `FK_training_training_toulet_id` FOREIGN KEY (`training_outlet_id`) REFERENCES `training_outlet` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `FK_training_training_type_id` FOREIGN KEY (`training_type_id`) REFERENCES `training_type` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of training
-- ----------------------------
INSERT INTO `training` VALUES (2, 2, 1, 'bbbbbbbb', 'bbbbbbbbbb', 'bbbbbbbbbbbbb', '2019-11-21', '2019-10-31', 555, 'bbbbbbbbbb', 5, 'jjjjjjjjjjjj', 5);
INSERT INTO `training` VALUES (10, 1, 1, 'hhhhhhhhhhh', 'hhhhhhhhhhhhh', 'hhhhhhhhhhhhhhhh', '2019-11-08', '2019-11-01', 6, 'hhhhhhhhh', 6, 'jjjjjjjjjj', 25);

-- ----------------------------
-- Table structure for training_outlet
-- ----------------------------
DROP TABLE IF EXISTS `training_outlet`;
CREATE TABLE `training_outlet`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of training_outlet
-- ----------------------------
INSERT INTO `training_outlet` VALUES (0, 'ندوات');
INSERT INTO `training_outlet` VALUES (1, 'البعثات');
INSERT INTO `training_outlet` VALUES (3, 'الحاسب');
INSERT INTO `training_outlet` VALUES (4, 'الندوات');
INSERT INTO `training_outlet` VALUES (5, 'الامن الصناعى');
INSERT INTO `training_outlet` VALUES (6, 'الثقافى');
INSERT INTO `training_outlet` VALUES (7, 'دراسات عليا');
INSERT INTO `training_outlet` VALUES (8, 'تفتيش');
INSERT INTO `training_outlet` VALUES (9, 'اسعافات اوليه');

-- ----------------------------
-- Table structure for training_type
-- ----------------------------
DROP TABLE IF EXISTS `training_type`;
CREATE TABLE `training_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of training_type
-- ----------------------------
INSERT INTO `training_type` VALUES (1, 'بعثه');
INSERT INTO `training_type` VALUES (2, 'دوره');
INSERT INTO `training_type` VALUES (3, 'مؤتمر');
INSERT INTO `training_type` VALUES (4, 'ندوه');
INSERT INTO `training_type` VALUES (5, 'دكتوراه');
INSERT INTO `training_type` VALUES (6, 'ماجستير');
INSERT INTO `training_type` VALUES (7, 'دبلوم');
INSERT INTO `training_type` VALUES (8, 'زماله');
INSERT INTO `training_type` VALUES (9, 'تفتيش');
INSERT INTO `training_type` VALUES (10, 'ورشه عمل');
INSERT INTO `training_type` VALUES (11, 'منتدى');
INSERT INTO `training_type` VALUES (12, 'زياره');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `date` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 's', 's', '2019-01-16 09:18:40');
INSERT INTO `user` VALUES (2, 'محمد', '2991993', '2019-01-16 09:19:14');

SET FOREIGN_KEY_CHECKS = 1;
