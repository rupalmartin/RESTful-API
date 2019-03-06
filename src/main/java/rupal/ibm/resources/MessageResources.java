package rupal.ibm.resources;

import rupal.ibm.model.Message;
import rupal.ibm.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

//path annotation can be mapped both to class and method.

@Path("/messages")
public class MessageResources {

    MessageService messageService = new MessageService();


    //APPLICATION_XML-- jaxb-api check in pom.xml
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Message> getMessage(){

        return messageService.getAllMessages();
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String gettest(){
        return "Test Succesfull";
    }

    //APPLICATION_JSON-- jersey-media-moxy check in pom.xml
    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessageId(@PathParam("messageId") long id){
        return messageService.getMessage(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)  //accespts json
    @Produces(MediaType.APPLICATION_JSON)  //produces json
    public Message addMessage(Message message){

        return messageService.addMessage(message);
    }

    @PUT
    @Path("/{messageId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message updateMessage(@PathParam("messageId") long id,Message message){
        message.setId(id);
        return messageService.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteMessage(@PathParam("messageId") long id){
        messageService.removeMessage(id);
    }






//    @GET
//    @Path("/{Id}")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String getid(){
//        return "Any variable message you can pass in url";
//    }


   // multiple path params

//    @GET
//    @Path("{id1}/{id2}")
//    @Produces(MediaType.APPLICATION_XML)
//    public Message getMMessages(@PathParam("id1") long id1,
//                                @PathParam("id2") long id2){
//
//         return messageService.getMessage(id1,id1);
//    }

}
