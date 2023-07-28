class Solution {
    public int countLargestGroup(int n) {
        
        int[] arr = new int[37];
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int tmp = i;
            while (tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            arr[sum]++;
        }
        int max = 0;
        for (int i = 0; i < 37; i++) {
            max = Math.max(max, arr[i]);
        }
        int cnt = 0;
        for (int i = 0; i < 37; i++) {
            if (arr[i] == max) {
                cnt++;
            }
        }
        return cnt;
    }
}