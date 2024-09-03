CREATE DATABASE  IF NOT EXISTS `scrummaster`;
USE `scrummaster`;
--
-- Table structure for table `scrum_tasks`
--
DROP TABLE IF EXISTS `scrum_projects`;

CREATE TABLE `scrum_projects` (
  `project_id` varchar(50) NOT NULL,
  `project_name` varchar(30) NOT NULL,
  `description` text NOT NULL,
  `created_by` varchar(10) NOT NULL,
  `team_involved` varchar(4000) NOT NULL,
  `created_on` datetime NOT NULL,
  `closed_on` datetime DEFAULT NULL,
  `active` numeric(1) NOT NULL check(active in (0,1)),
  `lchgtime` datetime NOT NULL,
  
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;
