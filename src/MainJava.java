public class MainJava {
    public static void main(String[] args) {
        final int i = maxScore(new int[]{32, 69, 37, 79, 4, 33, 29, 33, 45, 1, 99, 90, 56, 24, 76}, 10);
        System.out.println(i);
    }

    public static int maxScore(int[] cardPoints, int k) {
        int max = 0, sum = 0;
        for (int i = 0; i < k; i++) sum += cardPoints[i];

        max = sum;
        for (int i = 1; i <= k; i++) {
            sum = sum + cardPoints[cardPoints.length - i] - cardPoints[k - i];
            System.out.println(String.format("%d + %d - %d = %d", sum, cardPoints[cardPoints.length - i], cardPoints[k - i], sum));
            max = Math.max(max, sum);
        }

        return max;
    }
    /**
     * 362 + 76 - 1 = 437
     * 437 + 24 - 45 = 416
     * 437 + 56 - 33 = 460
     * 460 + 90 - 29 = 521
     * 521 + 99 - 33 = 587
     * 587 + 1 - 4 = 584
     * 587 + 45 - 79 = 553
     * 587 + 33 - 37 = 583
     * 587 + 29 - 69 = 547
     * 587 + 33 - 32 = 588
     */
}
