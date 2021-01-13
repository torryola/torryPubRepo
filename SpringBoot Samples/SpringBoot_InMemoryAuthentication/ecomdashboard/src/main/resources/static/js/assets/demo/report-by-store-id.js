// Script for generate Link to Each store reports using store Id

//$(sId).attr.('href', 'http:// 192.168.0.3:8080/home/branches/?Id='+sId);

//var id_value =
function  generate_link()
{
    var id_value;

    var sId = $("Ecom478").val();
   // var sId2 = $("Ecom479").val()
    //if(!sId1)
      //sId.setAttribute.('href', 'http://localhost:8080/home/branches/?Id='+sId);
       document.getElementById("Ecom478").href = "http://localhost:8080/home/branches/?Id="+sId;
}