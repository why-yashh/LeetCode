# Write your MySQL query statement below

SELECT S.score, count(S2.score) as 'rank'  from Scores S, (SELECT DISTINCT SCORE FROM SCORES) S2
WHERE S.SCORE <= S2.SCORE GROUP BY S.ID ORDER BY S.SCORE DESC;  