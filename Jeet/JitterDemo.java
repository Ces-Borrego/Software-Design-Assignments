public class JitterDemo {
    public static void main(String[] args) {

        Jeet shakeJeet = new Jeet("(7:^]", "William Shakespeare", "shakespeare", true);
        Jeet fakeShakeJeet = new Jeet("o_O", "Wilhelm Shakespeare", "fakeShake", false);
        Jeet jadenJeet = new Jeet(":-|","Jaden Smith", "officialJaden", true);
        System.out.println("\n===== Welcome to Jitter! =====\n");

        shakeJeet.setDate(new JitterDate("November", 1, 1611, 3, 37, true));


        String shakeText = "Our revels now are ended. These our actors,"
                + " as I foretold you, were all spirits and are melted into air,"
                + " into thin air. And, like the baseless fabric of this vision,"
                + " The cloud-capp'd towers, the gorgeous palaces,"
                + " The solemn temples, the great globe itself,"
                + " Yea, all which it inherit, shall dissolve...";

        shakeJeet.setJeet(shakeText);


        fakeShakeJeet.setDate(new JitterDate("November", 1, 1611, 6, 42, false));
        fakeShakeJeet.setJeet(shakeText);

        jadenJeet.setDate(new JitterDate("May", 1, 2013, 6, 23, false));
        jadenJeet.setJeet("How Can Mirrors Be Real If Our Eyes Aren't Real");

        fakeShakeJeet.plagiarismCheck(shakeJeet);
        jadenJeet.plagiarismCheck(shakeJeet);

        System.out.println(shakeJeet);
        System.out.println(fakeShakeJeet);
        System.out.println(jadenJeet);

        System.out.println("===== End of Jitter feed =====\n");
        System.out.printf("Jitter has shipped a total of %d jeet(s)"
                + " and detected %d fake jeet(s).%n", Jeet.getNumJeets(), Jeet.getNumFakeJeets());
    }
}