
package Modelo;

import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;

public class HashMD5 {

    public static String encode (String secretkey, String cadena) {
        String encriptacion = " ";
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] llavepassword = md5.digest(secretkey.getBytes("utf-8"));
            byte[] byteskey = Arrays.copyOf(llavepassword, 24);
            SecretKey key = new SecretKeySpec(byteskey, "DESede");
            Cipher cifrado = Cipher.getInstance("DESede");
            cifrado.init(Cipher.ENCRYPT_MODE, key);
            byte[] plaintextbytes = cadena.getBytes("utf-8");
            byte[] buf = cifrado.doFinal(plaintextbytes);
            byte[] base64bytes = Base64.encodeBase64(buf);
            encriptacion = new String(base64bytes);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "ENCRIPTACIÓN", JOptionPane.WARNING_MESSAGE);
        }
        return encriptacion;
    }
    
    public static String deencode (String secretkey, String cadenaencriptada) {
        String desencriptacion = " ";
        try {
            byte[] message = Base64.decodeBase64(cadenaencriptada.getBytes("utf-8"));
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digestofpassword = md5.digest(secretkey.getBytes("utf-8"));
            byte[] byteskey = Arrays.copyOf(digestofpassword, 24);
            SecretKey key = new SecretKeySpec(byteskey, "DESede");
            Cipher descifrado = Cipher.getInstance("DESede");
            descifrado.init(Cipher.DECRYPT_MODE, key);
            byte[] plaintext = descifrado.doFinal(message);
            desencriptacion = new String(plaintext, "UTF-8");
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "DESENCRIPTACIÓN", JOptionPane.WARNING_MESSAGE);
        }
        return desencriptacion;
    }
}
