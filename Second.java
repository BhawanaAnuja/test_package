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

public class Second extends Agent {
    String Msg, Msg1;
    
    protected void setup() {
       // System.out.println("Hello");
    
    // receiving messages from First
    addBehaviour(new CyclicBehaviour(this) {
            
            MessageTemplate mt=MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
            //MessageTemplate mt1=MessageTemplate.MatchPerformative(ACLMessage.INFORM);
            ACLMessage mt1=new ACLMessage(ACLMessage.INFORM);
            @Override
            public void action() {
                
                ACLMessage msg=receive(mt);
                
                if(msg!=null) {
                    msg.clearAllReceiver();
                    Msg=msg.getContent();
                    System.out.println(Msg);
                    mt1.setContent("Hello");
                    mt1.addReceiver(new AID("first",AID.ISLOCALNAME));
                    send(mt1);
                   
                    
                }
            }
        });
    
}

    
}
