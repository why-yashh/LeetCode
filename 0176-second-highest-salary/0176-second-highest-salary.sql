# Write your MySQL query statement below

SELECT (SELECT DISTINCT salary FROM Employee Order By salary DESC LIMIT 1 OFFSET 1) AS SecondHighestSalary ; 


# SELECT MAX(salary) AS SecondHightestSalary FROM Employee WHERE salary <(SELECT MAX(salary) FROM Employee);