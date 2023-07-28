class Solution {
    public int countLargestGroup(int n) {
        
        int[] count = new int[37];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int t = i;
            while (t > 0) {
                sum += t % 10;
                t /= 10;
            }
            max = Math.max(max, ++count[sum]);
        }
        int ans = 0;
        for (int i = 0; i < 37; i++) {
            if (count[i] == max) {
                ans++;
            }
        }
        return ans;
    }
}