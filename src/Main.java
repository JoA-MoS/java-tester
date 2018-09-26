import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {

        // for (int i = 0; i<10000; i++) {
        // System.out.println(generateTempPassword());
        // }

        Map<String, Integer> SmDmsUser = new HashMap<String, Integer>();
        SmDmsUser.put("DMSUSER_DISABLED_ADMINDISABLED", 1);

        String[] SmDmsUserName = { "DMSUSER_DISABLED_ADMINDISABLED", "DMSUSER_DISABLED_DISABLEDMASK" };

        int DMSUSER_DISABLED_ADMINDISABLED = 1;
        int DMSUSER_DISABLED_DISABLEDMASK = 16777215;
        int DMSUSER_DISABLED_ENABLED = 0;
        int DMSUSER_DISABLED_INACTIVITY = 4;
        int DMSUSER_DISABLED_MAXLOGINFAIL = 2;
        int DMSUSER_DISABLED_PEERDISABLED = 16;
        int DMSUSER_DISABLED_PWEXPIRED = 8;
        int DMSUSER_DISABLED_PWMUSTCHANGE = 16777216;

        int disabledState = DMSUSER_DISABLED_ENABLED;
        disabledState &= (~DMSUSER_DISABLED_ADMINDISABLED);
        System.out.println(disabledState);

        for (int i = 0; i < 500; i++) {
            System.out.println(generateTempPassword(10, 10));

        }

    }

    /**
     * Temporary password should be 8 characters long and must have 2 numbers.
     *
     * @return new password
     */
    static String generateTempPassword(int letters, int numbers) {

        char[] alphabetArr = "ABCDEFGHJKLMNPQRSTUVWXYZ".toCharArray();
        char[] numbersArr = "23456789".toCharArray();

        char[] alpha = getRandomFromArray(letters, alphabetArr);
        char[] nums = getRandomFromArray(numbers, numbersArr);

        char[] combined = Arrays.copyOf(alpha, alpha.length + nums.length);
        System.arraycopy(nums, 0, combined, alpha.length, nums.length);

        shuffleArray(combined);
        return new String(combined).toUpperCase();
    }

    static char[] getRandomFromArray(int count, char[] sourceSet) {
        char[] result = new char[count];
        Random rnd = ThreadLocalRandom.current();
        for (int i = 0; i < count; i++) {
            int randomIndex = rnd.nextInt(sourceSet.length);
            result[i] = sourceSet[randomIndex];
        }
        return result;
    }

    static void shuffleArray(char[] ar) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            char a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}
