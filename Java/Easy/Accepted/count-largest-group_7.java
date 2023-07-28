class Solution {
    public int countLargestGroup(int n) {
        
        int[] count = new int[37];
        for (int i = 1; i <= n; i++) {
            count[sumOfDigits(i)]++;
        }
        int max = 0;
        for (int i : count) {
            max = Math.max(max, i);
        }
        int ans = 0;
        for (int i : count) {
            if (i == max) {
                ans++;
            }
        }
        return ans;
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