public class Velocity {
    private int horizontalVelocity;
    private int verticalVelocity;

//Constructor:
    public Velocity(int horizontalVelocity, int verticalVelocity) {
        this.horizontalVelocity = horizontalVelocity;
        this.verticalVelocity = verticalVelocity;
    }

    //Getter Methods:
    public int getHorizontalVelocity() {
        return horizontalVelocity;
    }

    public int getVerticalVelocity() {
        return verticalVelocity;
    }

//Setter Methods:

    public void setHorizontalVelocity(int horizontalVelocity) {
        this.horizontalVelocity = horizontalVelocity;
    }

    public void setVerticalVelocity(int verticalVelocity) {
        this.verticalVelocity = verticalVelocity;
    }
}
