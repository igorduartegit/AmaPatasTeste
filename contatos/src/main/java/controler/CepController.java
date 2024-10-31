package controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.contatos.model.Endereco;
import com.contatos.service.CepService;

// TODO: Auto-generated Javadoc
/**
 * The Class CepController.
 */
@RestController
@CrossOrigin(origins = "*")
public class CepController {

    /** The cep service. */
    @Autowired
    private CepService cepService;

    /**
     * Buscar cep.
     *
     * @param cep the cep
     * @return the response entity
     */
    @GetMapping("/cep/{cep}")
    public ResponseEntity<Endereco> buscarCep(@PathVariable String cep) {
        Endereco endereco = cepService.buscarEnderecoPorCep(cep);

        if (endereco != null) {
            return ResponseEntity.ok(endereco);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
