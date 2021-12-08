package stresstest.demo.Contreoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stresstest.demo.Auxiliary;
import stresstest.demo.Model.Monster;

import java.util.Optional;

@RestController
public class Controller {

    @GetMapping("/monstrum")
    @ResponseBody
    public void monstrum(
            @RequestParam(required = true) String name,
            @RequestParam(required = true) Integer monsterStrength,
                        @RequestParam(required = false) Integer eyes,
                         @RequestParam(required = false) Integer noses,
                         @RequestParam(required = false) Integer paws,
                         @RequestParam(required = false) Boolean isFlying

    ) {

        Auxiliary auxiliary = new Auxiliary();
        Monster newMonster = auxiliary.monsterGeneration(name, Optional.ofNullable(eyes)
                , Optional.ofNullable(noses)
                , Optional.ofNullable(paws)
                , Optional.ofNullable(isFlying)
        );
        auxiliary.attack(monsterStrength);
    }
}
