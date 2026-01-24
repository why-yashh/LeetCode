# Write your MySQL query statement below

SELECT e2.name AS Employee from Employee e1 inner join employee e2 ON e1.id= e2.managerId where e1.salary<e2.salary;