class Solution {
    public boolean validPartition(int[] nums) {
        
        int len = nums.length;
        int[] count = new int[1000001];
        int[] less = new int[1000001];
        int[] more = new int[1000001];
        for (int n : nums) {
            count[n]++;
        }
        for (int i = 1; i <= 1000000; i++) {
            less[i] = less[i - 1] + count[i - 1];
        }
        for (int i = 1000000; i >= 1; i--) {
            more[i] = more[i + 1] + count[i + 1];
        }
        for (int i = 1; i <= 1000000; i++) {
            if (count[i] >= 2 && less[i] >= 1) {
                return true;
            }
            if (count[i] >= 3) {
                return true;
            }
            if (count[i] >= 1 && i <= 1000000 - 2 && more[i + 2] >= 1) {
                return true;
            }
        }
        return false;
    }
}