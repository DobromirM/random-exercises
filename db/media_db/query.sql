### Dobromir Marinov
### This script executes all the queries

# Use the database
USE world_news_corp_cms;


### Query 1
SELECT FirstName, LastName, Age
FROM Authors;

### Query 2
SELECT AVG(Age)
FROM Authors
WHERE Gender = 'Male';

### Query 3
SELECT FirstName, LastName, Salary
FROM Authors
WHERE Salary = 
(
	SELECT MAX(Salary) 
	FROM Authors
);

### Query 4
SELECT FirstName, LastName
FROM Authors
WHERE NI NOT IN 
(
	SELECT written_by 
	FROM Articles
);

### Query 5
SELECT Title, Topic, 
(
	SELECT FirstName 
	FROM Authors 
	WHERE NI = written_by
) AS FirstName, 
(
	SELECT LastName 
	FROM Authors 
	WHERE NI = written_by
) AS LastName
FROM Articles
WHERE Content LIKE '%George Clooney%' OR Content LIKE '%David Cameron%';

### This script ends here
