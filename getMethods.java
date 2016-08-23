package test_package;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bhawana
 */
import jade.core.Agent;
import java.util.Iterator;
public class getMethods extends Agent {
    

protected void setup() {
// Printout a welcome message
System.out.println("Hello World. I’m an agent!");
System.out.println("Hello World. I’m an agent!");
System.out.println("My local-name is "+getAID().getLocalName());
System.out.println("My GUID is "+getAID().getName());
System.out.println("My addresses are:");
Iterator it = getAID().getAllAddresses();
while (it.hasNext()) {
System.out.println("- "+it.next());
}

}
}
