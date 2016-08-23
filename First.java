/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test_package;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.core.AID;

public class First extends Agent {
    String Msg;
    protected void setup() {
       // System.out.println("Hello");
    
    String s;
    ACLMessage msg=new ACLMessage(ACLMessage.REQUEST);
    msg.setContent("Hi");
    msg.addReceiver(new AID("second",AID.ISLOCALNAME));
    send(msg);
    
     addBehaviour(new CyclicBehaviour(this) {
            
            MessageTemplate mt=MessageTemplate.MatchPerformative(ACLMessage.INFORM);
            //MessageTemplate mt1=MessageTemplate.MatchPerformative(ACLMessage.INFORM);
            //ACLMessage mt1=new ACLMessage(ACLMessage.INFORM);
            @Override
            public void action() {
                
                ACLMessage msg1=receive(mt);
                
                if(msg1!=null) {
                    msg1.clearAllReceiver();
                    Msg=msg1.getContent();
                    
                   System.out.println(Msg);
                    
                }
            }
        });
            
    
    
}
}
