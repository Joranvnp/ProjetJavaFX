package Test;

import com.example.projetjavafx.HelloController;
import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class HelloControllerTest {

    @Test
    void onHelloButtonClickTest() throws NoSuchAlgorithmException, NoSuchProviderException {
        HelloController a = new HelloController();
        String utilisateur, mdp, mdpVerif, hash;
        utilisateur = "utilisateur";
        mdp ="oui";

        Hasher hasher = Hashing.sha256().newHasher();
        hasher.putString(mdp, Charsets.UTF_8);
        HashCode sha256 = hasher.hash();
        mdpVerif = sha256.toString();

        Hasher hasher2 = Hashing.sha256().newHasher();
        hasher.putString("oui", Charsets.UTF_8);
        HashCode sha2562 = hasher2.hash();
        mdp = sha2562.toString();

        assertEquals(mdp, mdpVerif);
        assertFalse(mdp =="oui");
    }
}