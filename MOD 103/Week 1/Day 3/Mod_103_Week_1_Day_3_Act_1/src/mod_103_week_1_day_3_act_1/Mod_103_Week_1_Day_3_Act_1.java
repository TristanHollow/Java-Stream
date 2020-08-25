
package mod_103_week_1_day_3_act_1;

public class Mod_103_Week_1_Day_3_Act_1 {

    public static void main(String[] args) {
        Shape sha = new Shape();
        circle cir = new circle();
        triangle tri = new triangle();
        square sqr = new square();
        
        sha.draw();
        cir.draw();
        tri.draw();
        sqr.draw();
        
        sha.erase();
        cir.erase();
        tri.erase();
        sqr.erase();
        
    }
    
}

    class Shape{
        public void draw() {
            System.out.println("a shape");
        }
        
        public void erase() {
            System.out.println("the shape");
        }
    }

    class circle extends Shape{
        @Override
        public void draw() {
            System.out.println("a circle");
        }
        
        @Override
        public void erase() {
            System.out.println("the circle");
        }
        
    }

    class triangle extends Shape{
        @Override
        public void draw() {
            System.out.println("a triangle");
        }
        
        @Override
        public void erase() {
            System.out.println("the triangle");
        }
    }

    class square extends Shape{
        @Override
        public void draw() {
            System.out.println("a square");
        }
        
        @Override
        public void erase() {
            System.out.println("the square");
        }
    }