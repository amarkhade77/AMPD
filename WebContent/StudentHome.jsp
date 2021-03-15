<%@ page import="Model.Student" %>
<%@ page import="java.util.Vector" %>
<%@ page import="Model.Subject" %>
<%@ page import="Model.Assignment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Welcome To HomePage</title>
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet">
    <link href="font/css/all.css" type="text/css" rel ="stylesheet">
    <script src="js/lib/jquery.js"></script>
    <script src="js/dist/jquery.validate.js"></script>
    <script src="js/lib/bootstrap.js"></script>
</head>
<body>
<%
    String uname="",email="";
    int b_id,c_id=-1;
    int roll_no;
    if(session!=null){

        email=(String)session.getAttribute("email");
        uname = Student.getFirstName(email);
        b_id = Student.getB_id(email);
        c_id = Student.getC_id(email);
        roll_no= Student.getRollNo(email);
        session.setAttribute("roll_no",roll_no);
        Vector SubNames;

        if(b_id==-1)
        {
            response.sendRedirect("EditProfile.jsp");

        }



    }
    else {
        response.sendRedirect("index.html");
    }

%>
<nav class="navbar navbar-dark bg-dark">
    <a class="navbar-brand" href="StudentHome.jsp"><i class="fas fa-terminal"></i> Home</a>

    <div class="nav navbar-nav navbar-center">
    <span class="navbar-text">&#160; &#160; &#160;&#160; &#160;&#160;&#160; &#160;&#160; Welcome
        <% out.print(uname); %>
    </span>
    </div>

    <div class="nav navbar-nav navbar-right">
        <span class="navbar-text"><a href="EditProfile.jsp"> <i class="fas fa-user-cog"></i> Edit Profile</a> &#160; &#160; &#160;&#160;&#160; <a id="Logout" href="LogOut"><i class="fas fa-power-off"></i> Logout</a></span>
    </div>

</nav>


<div class="container">
    <br>
    <div class="text-center"><h3>Choose A Subject</h3></div>
    <div class="row h-75">

        <%
            int count1 = 0;
            Vector SNames = Subject.getSubjectNamesFromC_id(c_id);
            if(SNames!=null) {

                for (int i = 0; i < SNames.size(); i++) {
                    int s_no = Integer.parseInt(((Vector)SNames.get(i)).get(1)+"");
                    out.print("<div class=\"col-lg-3 col-md-6 ");
                    out.print("\">\n" +
                            "        <div class=\"card shadow p-3 mb-5 bg-white border-dark rounded\">\n" +
                            "            <div class=\"card-body\">" +
                            "<h5 class=\"card-title text-center\">");

                    out.print(((Vector) (SNames.get(i))).get(0));
                    out.print("</h5>");
                    int count = Assignment.getAssignmentCountFromSub_id(s_no);
                    String str = "Contains "+ count +" Assignment";
                    if(count > 1)
                        str+="s";
                    out.print("<h6 class=\"card-subtitle mb-2 text-info\">"+str+" </h6>");
                    out.print("<br>");

                    out.print("<div class=\"my-auto text-center text-muted\">");
                    String link = "ViewAssignment.jsp?sub_id="+s_no;


                    out.print("<a class=\"btn btn-outline-dark\"href= \""+link+"\" >");
                    out.print("<i class=\"fas fa-chevron-right\"></i>");
                    out.print("</a>");
                    out.print("</div>");


                    out.print("</div> </div> </div>");
                    count1++;
                    if(count1 >=4)
                    {
                        out.print("</div>");
                        out.print("<div class=\"row\">");
                        count1 = 0;
                    }


                }
            }
        %>


    </div>

</div>




</body>
</html>
