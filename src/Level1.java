public class Level1 {

    public static String PatternUnlock(int N, int [] hits)  {
        double sum = 0;


        for (int x = 0; x < hits.length - 1; x++) {
            if (hits[x+ 1] - hits[x] == 1 || hits[x+ 1] - hits[x] == -1)
                sum += 1;
            else
            if (hits[x] + hits[x + 1] == 8 || hits[x] + hits[x + 1] == 6 || hits[x] + hits[x + 1] == 11 || hits[x] + hits[x + 1] == 9)
                sum += 1.414213;
            else
                sum += 1;
        }


        String s = String.valueOf(sum*100000);
        char digit = s.charAt(7);
        if (digit > '5')
            sum += 0.00001;


        int f = 0;
        sum *= 100000;
        int sum2 = 0;
        int des = 1;

        for (int i = 0; sum > 1; i++, sum /= 10) {
            f = (int)(sum % 10);
            if (f != 0) {
                sum2 += f * des;
                des *= 10;
            }
        }

        String result = String.valueOf(sum2);


        return result;

    }
    public static void main(String[] args) {

    }
}