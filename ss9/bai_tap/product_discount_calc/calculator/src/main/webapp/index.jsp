<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="/calculate" method="post">
    <table>
        <tr>
            <td>First operand : </td>
            <td><input name="first-operator" type="number" value="${requestScope['first-operator']}"></td>
        </tr>
        <tr>
            <td>Operand : </td>
            <td><select name="operator">
                <option value="+" ${operator.equals("+") ? "selected" : ""}>+ Addition</option>
                <option value="-" ${operator.equals("-") ? "selected" : ""}>- Subtraction</option>
                <option value="x" ${operator.equals("x") ? "selected" : ""}>X Multiplication</option>
                <option value="/" ${operator.equals("/") ? "selected" : ""}>/ Division</option>
            </select></td>
        </tr>
        <tr>
            <td>Second operand : </td>
            <td><input name="second-operator" type="number" value="${requestScope['second-operator']}"></td>
        </tr>
    </table>
    <button type="submit" name="submit">Result</button>
    <input name="result" disabled  value="${requestScope['result']}">
</form>
</body>
</html>