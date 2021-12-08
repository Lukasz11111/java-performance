package stresstest.demo.Model;

import java.util.ArrayList;

public class Village {
    private ArrayList <Villager> villagers;
    private boolean destroyed;

    public Village() {
        ArrayList<Villager> result=new ArrayList<>();
        for (int i=0;i<100;i++){
            result.add(new Villager());
        }
        this.villagers = result;
        this.destroyed = false;
    }

    public ArrayList<Villager> getVillagers() {
        return villagers;
    }

    public void setVillagers(ArrayList<Villager> villagers) {
        this.villagers = villagers;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }
}
