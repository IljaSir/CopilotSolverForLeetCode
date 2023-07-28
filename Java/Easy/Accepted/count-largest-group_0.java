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
        int result = 0;
        for (int i = 0; i < groups.length; i++) {
            if (max < groups[i]) {
                max = groups[i];
                result = 1;
            } else if (max == groups[i]) {
                result++;
            }
        }
        return result;
    }
}