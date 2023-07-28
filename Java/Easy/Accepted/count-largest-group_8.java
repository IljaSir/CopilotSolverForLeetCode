class Solution {
    public int countLargestGroup(int n) {
        
        int[] groups = new int[37];
        for (int i = 1; i <= n; i++) {
            groups[sumOfDigits(i)]++;
        }
        int max = 0;
        int count = 0;
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] > max) {
                max = groups[i];
                count = 1;
            } else if (groups[i] == max) {
                count++;
            }
        }
        return count;
    }
    private int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}