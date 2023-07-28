class Solution {
    public int countLargestGroup(int n) {
        
        int[] groups = new int[37];
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int num = i;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            groups[sum]++;
        }
        int max = 0;
        int count = 0;
        for (int i = 0; i < 37; i++) {
            if (groups[i] > max) {
                max = groups[i];
                count = 1;
            } else if (groups[i] == max) {
                count++;
            }
        }
        return count;
    }
}