# Write your MySQL query statement below
#SELECT P.firstName, P.lastName, A.city, A.state from Person As P, Address As A where P.personId = A.personId;


SELECT P.firstName, P.lastName, A.city, A.state FROM Person AS p LEFT JOIN Address AS A ON p.personId = A.personId;