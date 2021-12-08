package stresstest.demo.Model;

public class Villager {
    private boolean isLive;
    private boolean hasAHouse;
    private boolean heHasAllHisHands;

    public Villager() {
        this.isLive = true;
        this.hasAHouse = true;
        this.heHasAllHisHands = true;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public boolean isHasAHouse() {
        return hasAHouse;
    }

    public void setHasAHouse(boolean hasAHouse) {
        this.hasAHouse = hasAHouse;
    }

    public boolean isHeHasAllHisHands() {
        return heHasAllHisHands;
    }

    public void setHeHasAllHisHands(boolean heHasAllHisHands) {
        this.heHasAllHisHands = heHasAllHisHands;
    }
}

