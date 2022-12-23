<%@ page import="java.util.ArrayList" %>
<%@ page import="com.lab.web.DTO.HitRow" %>
<%@ page import="com.lab.web.util.HitRowFormatter" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link id="page_favicon" href="data:image/x-icon;base64,AAACAAEAICAQAAAAAADoAgAAFgAAACgAAAAgAAAAQAAAAAEABAAAAAAAAAIAAAAAAAAAAAAAEAAAAAAAAAAAAAAAIR8dAEJAPQC5ufAAoaHwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAREREREREREAAAAAAAABERESIiIiIiEhEgAAAAAAESIiIiIiIiIiIiIRAAAAASIiIiERERESIiIiIRAAAAIiIiIRRERERCIiIiIAAAACIiIRRERERERBEiIiIAAAAiIiFERERERERBEiIiAAAAIiIkRERERERERBIiIgAAAiIiFERERERERERCIiIAAAIiIhREQ0REREREQiIiIAACIiIURERERDM0RCIiIiAAAiIiIkREMzMzREIiIiIgAAIiIiIkRDMzMzRCERESIAACERESIkRDMzNEIiREEQAAAhREEiIkREREQiJEREEgAAFEREIiIkRERCIiRERCIAAiRERCIiJEREIiIkM0RCAAIjRDMiIiJERCIiIkMzQiAAIzM0IiIiIiIiIiIkMyIAACJDMiIREiIiIRESIiIiAAACIiIhFBEiIhFEESIiIgAAACIiJEREIiIkREEiIiAAAAACIiNEMyIiJEREIiIgAAAAAiIjRDQiIiNEQiIgAAAAAAAhI0MyIiIjMzQiIAAAAAAAAiIzIiIiIkQiIgAAAAAAAAAiIiIgACIiIiIAAAAAAAAAAAIgAAAAIgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAD///////////+AAP/4AAA/8AAAD+AAAAfAAAAHwAAAB8AAAAPAAAADgAAAAYAAAAGAAAABgAAAAYAAAAGAAAABgAAAAQAAAAAAAAAAAAAAAAAAAACAAAABgAAAAcAAAAPgAAAD+AAAB/gAAAf4AAAP/AAAH/4AgD//z/P//////w==" rel="icon" type="image/x-icon">
    <title>Web lab 2</title>
    <meta charset="UTF-8">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/svg.js/3.1.2/svg.min.js" integrity="sha512-I+rKw3hArzZIHzrkdELbKqrXfkSvw/h0lW/GgB8FThaBVz2e5ZUlSW8kY8v3q6wq37eybIwyufkEZxe4qSlGcg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://code.jquery.com/jquery-3.6.1.js"></script>
    <script type="text/javascript" src="js/RequestHandler.js"></script>
    <script type="text/javascript" src="js/ValidationHandler.js"></script>
    <script type="text/javascript" src="js/TableUpdate.js"></script>
    <script type="text/javascript" src="js/DataHandler.js"></script>
    <link rel="stylesheet" href="styles/body.css">
    <link rel="stylesheet" href="styles/form.css">
    <link rel="stylesheet" href="styles/header.css">
    <link rel="stylesheet" href="styles/table.css">
</head>
<body onload="firstDrawHandler();">
<% ServletContext servletContext = request.getServletContext();
    ArrayList<HitRow> hitRows = (ArrayList<HitRow>)servletContext.getAttribute("data");

%>


<div id="header">
    <div><img src="public/rolling-cat.gif" width="50" alt=""></div>
    <div>Welcome to kitten page ^_^ Made by Kondrateva Ksenia Р32121 1224</div>
    <div><img src="public/rolling-cat.gif" width="50" alt=""></div>
</div>

<div class="main_and_gifs" style="display: flex;">
    <img src="public/kitty_hit.gif" style="margin: 10px" width="220" height="272" alt="">
<div class="main" style="display:grid; justify-content: center;">

<div class="form_and_graph" style="display: flex; margin: 10px">

    <!-- Form to send -->
    <div>

            <div class="forms" id="forms">
                <div class="values">
                    <div>
                        <div>Please don't disappoint kitten and choose the right coordinates ^_^</div>
                        <form method="POST" onsubmit="sendFormRequest(); return false;" style="display: grid">
                            <div class="X_value" style="margin-bottom: 10px ">
                                <label for="X_value">X value: [-3..5] </label><select name="X_value" size="1" id="X_value">
                                    <option value="-3">-3</option>
                                    <option value="-2">-2</option>
                                    <option value="-1">-1</option>
                                    <option value="0">0</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                </select>

                            </div>
                            <div style="margin-bottom: 10px ">
                                <label for="Y_value"> Y value: (-3..5)</label>
                                    <input type="text" name="y_value" id="Y_value" placeholder="Enter Y value"/>

                            </div>

                            <div>
                                    <label for="R_value" > R value: (2..5)</label>

                                    <input type="text"  onchange="" name="r_value" id="R_value" placeholder="Enter R value"/>

                            </div>
                            <!-- Error text block -->
                            <div class="error_text" id="error_text" style="margin: 4px; display:grid;">
                                <span id="X_error"></span>
                                <span id="Y_error"></span>
                                <span id="R_error"></span>
                            </div>
                            <!-- Buttons reset and submit block -->
                            <div class="buttons" style="display: flex; justify-self: center; align-self: center;
                             align-items: center; margin-left: 130px">
                                <div>
                                <input type ="submit" value="submit" id="submit">
                                </div>
                            </div>

                        </form>
                    </div>
            </div>
            </div>
    </div>
    <canvas id='plot' width="300" height="300" ></canvas>
</div>
    <!-- table blocks -->
    <div style="margin-left: 20px; display: grid; justify-items: center; align-content: flex-start;">
        <div>
            <table id="table">
                <thead>
                <tr>
                    <th>X coordinate</th>
                    <th>Y coordinate</th>
                    <th>Radius</th>
                    <th>Result</th>
                    <th>Current time</th>
                    <th>Execution time</th>
                </tr>
                </thead>
                <tbody>
               <%= HitRowFormatter.getRows(hitRows)%>
            </table>
        </div>

        <!-- Clean table block -->
        <div id="cleaner" class="cleaner">
            <input type="button" value="Clean" id="clear_button" onclick="clean();">
        </div>

    </div>

</div>
    <img src="public/kitty_walk.gif" width="220" height="277" style="margin: 10px" alt="">
</div>
</body>
<script type="text/javascript" src="js/GraphHandler.js"></script>
<script>getDots(<%= HitRowFormatter.getDots(hitRows)%>)</script>

</html>