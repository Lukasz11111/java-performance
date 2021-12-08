package stresstest.demo;

import stresstest.demo.Model.Monster;
import stresstest.demo.Model.Village;
import stresstest.demo.Model.Villager;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class Auxiliary {

    public Monster monsterGeneration(String name,Optional<Integer> eyes, Optional<Integer> noses, Optional<Integer> paws, Optional<Boolean> isFlying){
        ArrayList<Integer> result= new ArrayList<>();
        result.add(getValueFromOptional(eyes));
        result.add(getValueFromOptional(noses));
        result.add(getValueFromOptional(paws));
        boolean flyMachin=false;
      if (isFlying.isPresent()){
          flyMachin=true;
      }
        int all=result.stream().reduce(0,MakeMonster::add);
        Consumer<Integer> consumer = s -> { s=s+3;};
        result.stream().forEach(consumer);


        Monster monster=new Monster(
                name,
                Integer.toString(result.get(0))
                ,Integer.toString(result.get(1))
                ,Integer.toString(result.get(2))
                ,flyMachin);
        return monster;
    }
    public int getValueFromOptional(Optional<Integer> e){
        AtomicInteger result= new AtomicInteger();
        e.ifPresentOrElse(
                (value)->{
                    result.set(value);
                },
                ()->{
                    result.set(random_(1,10));
                });
        return result.intValue();
    }

    public int random_(int minimum,int maximum){
       int randomNum = minimum + (int)(Math.random() * maximum);
        return randomNum;
    }

    public boolean attack(int monsterStrength){
        Village village=new Village();
        ArrayList<Villager> villagers= village.getVillagers();
        ArrayList<Boolean> deadViligers=new ArrayList<>();
        villagers.stream().forEach(e ->{
            int chanceOfSurvival=random_(0,100000);
            if(monsterStrength>chanceOfSurvival){
                e.setLive(false);
                deadViligers.add(true);
            }else{
                e.setHasAHouse(false);
                e.setHeHasAllHisHands(false);
            }

        });
        int chanceOfSurvivalVilige=random_(0,100000);
        if(chanceOfSurvivalVilige<=monsterStrength){
            village=null;
            village.setDestroyed(true);
        }
        return true;
    }

}
