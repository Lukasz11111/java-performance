package stresstest.demo.Model;

public class Monster {

    private String name;
    private  String eyes;
    private  String noses;
    private  String paws;
    private  Boolean isFlying;


    public Monster(String name, String eyes, String noses, String paws, Boolean isFlying) {
        this.name = name;
        this.eyes = eyes;
        this.noses = noses;
        this.paws = paws;
        this.isFlying = isFlying;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    public String getNoses() {
        return noses;
    }

    public void setNoses(String noses) {
        this.noses = noses;
    }

    public String getPaws() {
        return paws;
    }

    public void setPaws(String paws) {
        this.paws = paws;
    }

    public Boolean getFlying() {
        return isFlying;
    }

    public void setFlying(Boolean flying) {
        isFlying = flying;
    }
}
