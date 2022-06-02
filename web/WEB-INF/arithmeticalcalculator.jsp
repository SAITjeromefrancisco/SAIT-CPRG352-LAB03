<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        <form method="POST" action="math">
            <label>First: </label>
            <input type="text" name="first_input" value="">
            <br>
            <label>Second: </label>
            <input type="text" name="second_input" value="">
            <br>
            <input type="submit" value="+" name="+">
            <input type="submit" value="-" name="-">
            <input type="submit" value="*" name="*">
            <input type="submit" value="%" name="%">            
        </form>
        <p>Result: ${message}</p>
        <a href="./calc">Age Calculator</a>
    </body>
</html>
