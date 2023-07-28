class Solution {
    public boolean gcdSort(int[] nums) {
        
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int[] p = new int[100001];
        for (int i = 2; i < p.length; i++) {
            if (p[i] == 0) {
                for (int j = i; j < p.length; j += i) {
                    p[j] = i;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != sorted[i]) {
                int a = nums[i];
                int b = sorted[i];
                while (a > 1) {
                    int d = p[a];
                    while (a % d == 0) {
                        a /= d;
                    }
                    while (b % d == 0) {
                        b /= d;
                    }
                }
                if (b > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}