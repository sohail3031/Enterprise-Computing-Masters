<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Ranking Service Test Page</title>
    <script>
      function getGrade() {
        var score = document.getElementById("score").value;
        fetch("/grade/" + score)
          .then((response) => response.text())
          .then(
            (data) => (document.getElementById("result").textContent = data)
          );
      }

      function getRank() {
        var score = document.getElementById("score").value;
        fetch("/rank/" + score)
          .then((response) => response.text())
          .then(
            (data) => (document.getElementById("result").textContent = data)
          );
      }

      function getGradeAndRank() {
        var score = document.getElementById("score").value;
        fetch("/grade-rank/" + score)
          .then((response) => response.text())
          .then(
            (data) => (document.getElementById("result").textContent = data)
          );
      }
    </script>
  </head>
  <body>
    <h1>Ranking Service Test</h1>
    <input type="number" id="score" placeholder="Enter score" />
    <button onclick="getGrade()">Get Grade</button>
    <button onclick="getRank()">Get Rank</button>
    <button onclick="getGradeAndRank()">Get Both</button>
    <div id="result"></div>
  </body>
</html>
