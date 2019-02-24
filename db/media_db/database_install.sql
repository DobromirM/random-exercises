### Dobromir Marinov
### This script creates a database named world_news_corp_cms and populates it with data

### Drop (if needed) and create the database
DROP DATABASE IF EXISTS world_news_corp_cms;
CREATE DATABASE world_news_corp_cms;
USE world_news_corp_cms;

## AUTHORS
CREATE TABLE Authors (
	NI				BIGINT UNSIGNED NOT NULL,
	FirstName		VARCHAR(30) NOT NULL,
	LastName		VARCHAR(30) NOT NULL,
	Gender			ENUM('Male', 'Female') NOT NULL,
	Age				INT UNSIGNED NOT NULL,
	Salary			DECIMAL(8,2),
	Country 		VARCHAR(30) NOT NULL,
	PRIMARY KEY (NI)
);

## ARTICLES
CREATE TABLE Articles (
	ArticleID		INT UNSIGNED NOT NULL AUTO_INCREMENT,
	Title			VARCHAR(50) NOT NULL,
	Content 		VARCHAR(250) NOT NULL,
	Date			DATE NOT NULL,
	Country 		VARCHAR(30) NOT NULL,
	Topic			ENUM('Financial', 'Politics', 'Sport', 'Science', 'Entertainment') NOT NULL,
	written_by		BIGINT UNSIGNED NOT NULL,
	PRIMARY KEY (ArticleID)
);

## COMMENTS
CREATE TABLE Comments (
	CommentID		INT UNSIGNED NOT NULL AUTO_INCREMENT,
	Username		VARCHAR(30) NOT NULL,
	Content 		VARCHAR(100) NOT NULL,
	Date			DATE NOT NULL,
	relates_to 	 	INT UNSIGNED NOT NULL,
	PRIMARY KEY (CommentID)
);

##LIKES
CREATE TABLE Likes (
	LikeID		INT UNSIGNED NOT NULL AUTO_INCREMENT,
	Time    	TIME NOT NULL,
	Date 		DATE NOT NULL,
	Liked		INT UNSIGNED NOT NULL,
	PRIMARY KEY (LikeID)
);

### POPULATE DATA
## AUTHORS
INSERT INTO Authors values(1987234920, 'John', 'Smith', 'Male', 34, 20000, 'England');
INSERT INTO Authors values(9348098234, 'Tom', 'Potter', 'Male', 32, 32000, 'Scotland');
INSERT INTO Authors values(4564547547, 'Jack', 'Kingman', 'Male', 23, 14000, 'India');
INSERT INTO Authors values(5654674575, 'Chris', 'Trethick', 'Male', 45, 24000, 'India');
INSERT INTO Authors values(5675675675, 'Dave', 'Carter', 'Male', 56, 40000, 'Ireland');
INSERT INTO Authors values(7775656765, 'Ian', 'Packwood', 'Male', 33, 19000, 'England');
INSERT INTO Authors values(8964334324, 'Lucy', 'Teague', 'Female', 18, 20000, 'America');
INSERT INTO Authors values(6612355667, 'Jane', 'Conor', 'Female', 19, 49000, 'France');
INSERT INTO Authors values(3456456457, 'Mary', 'Van Schmidt', 'Female', 42, 32000, 'France');
INSERT INTO Authors values(1875432325, 'Liz', 'Fogarty', 'Female', 53, 34000, 'America');
INSERT INTO Authors values(1134576877, 'Emma', 'Baker', 'Female', 37, 20000, 'England');
INSERT INTO Authors values(2345457654, 'Anne', 'Nuttley', 'Female', 43, 34000, 'Indonesia');

## ARTICLES
INSERT INTO Articles values(1, 'Europe crackdown on jihadist network', 'Police target 17 people in raids in several European countries on suspicion of links to a jihadist network.', CURDATE(), 'England', 'Politics', 1987234920);
INSERT INTO Articles values(2, 'Modi visit historic opportunity for UK', 'Indian prime minister arrives in the UK for a three day visit, described by David Cameron as a historic opportunity for both countries.', CURDATE(), 'India', 'Politics', 9348098234);
INSERT INTO Articles values(3, 'Sweden brings in migrant border checks', 'Sweden brings in temporary border checks to control the flow of migrants into the country, as an EU Africa summit continues.', CURDATE(), 'Sweden', 'Politics', 5675675675);
INSERT INTO Articles values(4, 'Apple apologises after racism outcry', 'Apple apologises to six schoolboys who were asked to leave one of their shops in Australia, in what the students described as a racist incident.', CURDATE(), 'Australia', 'Financial', 7775656765);
INSERT INTO Articles values(5, 'HMRC reveals tax office shake-up', 'The UKs tax authority will close 137 local offices and replace them with 13 regional centres, raising fears over job losses.', CURDATE(), 'England', 'Financial', 1134576877);
INSERT INTO Articles values(6, 'Film star visits cafe for homeless', 'Hollywood star George Clooney visits a sandwich shop which helps homeless people during a visit to Edinburgh.', CURDATE(), 'Scotland', 'Entertainment', 1987234920);
INSERT INTO Articles values(7, 'Rolls-Royce shares dive on profit woes', 'Shares in aerospace group RollsRoyce sink after it warns that its profits will be hit by sharply weaker demand.', CURDATE(), 'England', 'Financial', 1134576877);
INSERT INTO Articles values(8, 'Ex-MPs GBP13,700 on shredding and skips', 'The Independent Parliamentary Standards Authority releases expenses claims for 182 MPs who left the Commons at the election - with GBP705,000 spent on closing down their offices.', CURDATE(), 'England', 'Politics', 1134576877);
INSERT INTO Articles values(9, 'Action needed to protect UK coast', 'The UK is ignoring known risks of flood and erosion at the coast and immediate action is needed to manage the threats, the National Trust warns.', CURDATE(), 'England', 'Science', 3456456457);
INSERT INTO Articles values(10, 'Venus twin excites astronomers', 'Astronomers hunting distant worlds say they have made one of their most significant discoveries to date, what could be a kind of hot twin to our Venus.', CURDATE(), 'America', 'Science', 2345457654);

## COMMENTS
INSERT INTO comments values(1, 'johny54', 'Apple is great.', '2016-12-05', 4);
INSERT INTO comments values(2, 'paella ', 'No, it is not.', '2016-12-06', 4);
INSERT INTO comments values(3, 'centipede_2', 'I love my Iphone.', '2016-12-07', 4);
INSERT INTO comments values(4, 'starbo00lins', 'You are racist!', '2016-12-07', 4);
INSERT INTO comments values(5, 'sKiNNy', 'I am here for the drama.', '2016-12-07', 4);
INSERT INTO comments values(6, 'estimat0r', 'We need one more comment.', '2016-12-08', 4);
INSERT INTO comments values(7, 'droning_d', 'OK, we are done.', '2016-12-08', 4);
INSERT INTO comments values(8, 'pyrenees', 'Who is George Clooney?', '2016-12-22', 6);
INSERT INTO comments values(9, 'phineasTheHuman', 'How can you not know who George Clooney is?', '2016-12-22', 6);
INSERT INTO comments values(10, 'pyrenees', 'Well I dont.', '2016-12-22', 6);
INSERT INTO comments values(11, 'phineasTheHuman', 'You are strange...', '2016-12-22', 6);
INSERT INTO comments values(12, 'pyrenees', 'Uhmm.. OK...', '2016-12-22', 6);
INSERT INTO comments values(13, 'jack_the_lumber', 'That is a great discovery.', '2017-01-17', 10);
INSERT INTO comments values(14, 'romeo', 'I dont know about Venus but I think the earth is flat.', '2017-01-19', 10);
INSERT INTO comments values(15, 'topsail', 'You are an idiot.', '2017-01-19', 10);
INSERT INTO comments values(16, 'augustus', 'ARE YOU STUPID!!!', '2017-01-19', 10);
INSERT INTO comments values(17, 'sassafras', 'Go to school!', '2017-01-19', 10);
INSERT INTO comments values(18, 'pilcrow22', 'Some random comment to fill space.', '2017-01-20', 10);
INSERT INTO comments values(19, 'c0dswa110p', 'I am from Sweden.', '2017-05-11', 3);
INSERT INTO comments values(20, 'clappER', 'Good for you.', '2017-05-11', 3);
INSERT INTO comments values(21, 'c0dswa110p', 'Thank you!', '2017-05-11', 3);
INSERT INTO comments values(22, 'knave', 'Why do I have to write all these comments...', '2017-05-12', 3);
INSERT INTO comments values(23, 'shapeless', 'I am running out of ideas.', '2017-09-13', 3);
INSERT INTO comments values(24, 'harry', 'And I need to eat something.', '2017-09-13', 3);
INSERT INTO comments values(25, 'minnie', 'But I dont have any food.', '2017-09-13', 3);
INSERT INTO comments values(26, 'roshanna', 'OK, lets write one more comment and start cooking.', '2017-09-13', 3);
INSERT INTO comments values(27, 'cricket', 'Here we go...', '2017-09-13', 3);

#LIKES
INSERT INTO Likes values(1, '21:12:57', '2016-12-04', 1);
INSERT INTO Likes values(2, '21:13:23', '2016-12-05', 1);
INSERT INTO Likes values(3, '09:29:17', '2016-12-06', 1);
INSERT INTO Likes values(4, '15:25:34', '2016-12-06', 3);
INSERT INTO Likes values(5, '17:29:08', '2016-12-06', 3);
INSERT INTO Likes values(6, '03:22:11', '2016-12-11', 3);
INSERT INTO Likes values(7, '17:00:17', '2016-12-15', 3);
INSERT INTO Likes values(8, '23:22:50', '2016-12-23', 10);
INSERT INTO Likes values(9, '01:02:03', '2016-12-24', 10);
INSERT INTO Likes values(10, '11:20:12', '2016-12-30', 7);
INSERT INTO Likes values(11, '12:22:10', '2016-12-30', 7);
INSERT INTO Likes values(12, '23:59:59', '2016-12-31', 7);
INSERT INTO Likes values(13, '13:33:37', '2017-09-13', 7);
INSERT INTO Likes values(14, '13:37:00', '2017-09-13', 7);

### This script ends here