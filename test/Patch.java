import java.net.IDN;


/**
 * Proof of concept for patch
 */
public class Patch {

    public static void main(String[] args) {
        String plain = "www.аррӏеstore.com";
        
        System.out.println(plain);
        
        String converted = IDN.toASCII(plain,3);

        System.out.println(converted);
    } 
}
