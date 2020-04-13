import java.util.Random;

public class Circle{
    Random random=new Random(1);
    private double radius=random.nextDouble();


    public Circle(double radius){
    }


    public double getRadius(){
        return radius;
    }

    public void setRadius(double radius){
        this.radius=radius;
    }


    @Override
    public String toString(){
        return "Circle{"+"radius="+radius+'}';
    }

    public double getArea(){
        return Math.pow(this.radius, 2) * Math.PI;
    }
}

