public class Main {
    private static final String MSG = "Submit Assignment 3 by 23:59";
    private static int total = 0;
    private static int passed = 0;

    public static void main(String[] args) {
        if (args.length == 1 && args[0].equals("--demo")) {
            runDemo();
        } else {
            System.out.println("Usage: java -cp out Main --demo");
        }
    }

    private static void runDemo() {
        check("T1", "Reminder + EmailChannel",
                new Reminder("r1", MSG, new EmailChannel()).execute(),
                "EMAIL delivered: [To: student@astanait.edu.kz | Subject: Notification r1 | Body: REMINDER: " + MSG + "]");
        check("T2", "Reminder + SmsChannel",
                new Reminder("r1", MSG, new SmsChannel()).execute(),
                "SMS delivered: [SMS] REMINDER: " + MSG);
        check("T3", "UrgentAlert + EmailChannel",
                new UrgentAlert("u1", MSG, new EmailChannel()).execute(),
                "EMAIL delivered: [To: student@astanait.edu.kz | Subject: Notification u1 | Body: URGENT: " + MSG + "]");
        check("T4", "UrgentAlert + SmsChannel",
                new UrgentAlert("u1", MSG, new SmsChannel()).execute(),
                "SMS delivered: [SMS] URGENT: " + MSG);

        checkSwitch();

        check("T6", "Reminder + PushChannel",
                new Reminder("r1", MSG, new PushChannel()).execute(),
                "PUSH delivered: {title: Notification r1, text: REMINDER: " + MSG + "}");
        check("T7", "UrgentAlert + PushChannel",
                new UrgentAlert("u1", MSG, new PushChannel()).execute(),
                "PUSH delivered: {title: Notification u1, text: URGENT: " + MSG + "}");

        System.out.println("SUMMARY: " + passed + "/" + total + " PASS");
    }

    private static void checkSwitch() {
        Notification original = new Reminder("r1", MSG, new EmailChannel());
        String before = original.execute();
        Notification afterSwitch = switchChannel(original, new SmsChannel());
        String after = afterSwitch.execute();

        boolean sameObject = original == afterSwitch;
        boolean stateUnchanged = afterSwitch.getId().equals("r1") && afterSwitch.getMessage().equals(MSG);
        String expectedBefore = "EMAIL delivered: [To: student@astanait.edu.kz | Subject: Notification r1 | Body: REMINDER: " + MSG + "]";
        String expectedAfter = "SMS delivered: [SMS] REMINDER: " + MSG;
        boolean ok = sameObject && stateUnchanged && before.equals(expectedBefore) && after.equals(expectedAfter);

        total++;
        if (ok) passed++;
        System.out.println("T5 " + (ok ? "PASS" : "FAIL") + " | sameObject=" + sameObject
                + " | stateUnchanged=" + stateUnchanged);
        System.out.println(" before=" + before + " | after=" + after);
        if (!ok) {
            System.out.println(" expected before=" + expectedBefore + " | expected after=" + expectedAfter);
        }
    }

    private static Notification switchChannel(Notification n, Channel c) {
        n.setImplementation(c);
        return n;
    }

    private static void check(String id, String classes, String actual, String expected) {
        boolean ok = actual.equals(expected);
        total++;
        if (ok) passed++;
        System.out.println(id + " " + (ok ? "PASS" : "FAIL") + " | " + classes + " | result=" + actual);
        if (!ok) System.out.println(" expected=" + expected);
    }
}
