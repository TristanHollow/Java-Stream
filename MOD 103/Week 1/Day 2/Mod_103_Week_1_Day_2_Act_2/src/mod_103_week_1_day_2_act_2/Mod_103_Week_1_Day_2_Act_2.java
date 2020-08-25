
package mod_103_week_1_day_2_act_2;

public class Mod_103_Week_1_Day_2_Act_2 {

    public static void main(String[] args) {

        String input = "It is late.";
        Backwards reverse = new Backwards(input);
        System.out.println("Length: " + reverse.length());
        System.out.println("Char at 2: " + reverse.charAt(2));
        System.out.println("SubSequence: 1-6 " + reverse.subSequence(1, 6));
        System.out.println("To String: " + reverse.toString());

    }

}

interface PersonMove {

    void walk();

    void run();
}

class PersonMovement implements PersonMove {

    public void walk() {
        System.out.println("walk!");
    }

    public void run() {
        System.out.println("run!");
    }
}

class Backwards implements CharSequence {

    private String name;

    public Backwards(String charSeq) {

        this.name = charSeq;

        char[] charArr = name.toCharArray();
        char[] reverseArr = charArr.clone();
        int rev = charArr.length - 1;
        for (int count = 0; count < charArr.length; count++) {
            reverseArr[rev] = charArr[count];
            rev--;
        }
        this.name = new String(reverseArr);
    }

    @Override
    public int length() {
        return name.length();
    }

    @Override
    public char charAt(int index) {
        return name.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return name.subSequence(start, end);
    }

    @Override
    public String toString() {
        return name;
    }

}
