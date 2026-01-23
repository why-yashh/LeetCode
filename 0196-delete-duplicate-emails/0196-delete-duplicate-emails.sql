# Write your MySQL query statement below
DELETE p FROM Person P JOIN Person p2 ON p.EMAIL = p2.EMAIL AND p.ID>p2.ID;