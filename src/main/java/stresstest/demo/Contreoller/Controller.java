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

    public void monstrum_(
            int monsterStrength,
            String name,
            Optional<Integer> eyes,
            Optional<Integer> noses,
            Optional<Integer> paws,
            Optional<Boolean> isFlying
    ) {
        Auxiliary auxiliary = new Auxiliary();
        Monster newMonster = auxiliary.monsterGeneration(name, eyes
                , noses
                , paws
                , isFlying
        );
        auxiliary.attack(monsterStrength);
    }


    @GetMapping("/")
    @ResponseBody
    public void getSuc() {
        monstrum_(0,"www",Optional.ofNullable(2),Optional.ofNullable(2),Optional.ofNullable(2),Optional.ofNullable(true));
    }

    @GetMapping("/err")
    @ResponseBody
    public void getErr() {
        monstrum_(100000,"www",Optional.ofNullable(22),Optional.ofNullable(23),Optional.ofNullable(22),Optional.ofNullable(false));
    }

    @GetMapping("/err-short")
    @ResponseBody
    public void getErrShort() {
        int a=0;
        a=a/a;
    }
    @GetMapping("/err-loop")
    @ResponseBody
    public void getErrLoop() {
        int a=0;
        for (int i=0;i<1000; i++){
        a=0;
        }
        a=a/a;
    }
}
