class Solution {
    public int countLargestGroup(int n) {
        
        int[] count = new int[37];
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int j = i;
            while (j > 0) {
                sum += j % 10;
                j /= 10;
            }
            count[sum]++;
        }
        int max = 0;
        for (int i = 0; i < count.length; i++) {
            max = Math.max(max, count[i]);
        }
        int res = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) {
                res++;
            }
        }
        return res;
    }
}