<!DOCTYPE html>
<html>
<body>

<p>Jason & Adonis's</p>
<img src="databaseproject.png" alt="Database" style="width:204px;height:186px;">
<hr>

<style>
.btn1 { width: 1000px }
</style>



<p> Select which action you would like to perform on the database using the buttons below: </p>
<form action="function1.php">
    <input type="submit" class="btn1" value="1) Add a student to the Student table" />
</form>
<hr>

<form action="function2.php">
    <input type="submit" class="btn1" value="2) Add a course to the Course table" />
</form>
<hr>

<form action="function3.php">
    <input type="submit" class="btn1" value="3) Add an application to the Enrollment table" />
</form>
<hr>

<form action="function4.php">
    <input type="submit" class="btn1" value="4) View all students (display all attributes in the table for each student)" />
</form>
<hr>

<form action="function5.php">
    <input type="submit" class="btn1" value="5) View all courses from a given department (display all attributes in the Course table for each course)" />
</form>
<hr>

<form action="function6.php">
    <input type="submit" class="btn1" value="6) View all courses for a given student (given the StudentID, display all attributes in the Course table for each course)" />
</form>
<hr>


<?php
?>

</body>
</html>