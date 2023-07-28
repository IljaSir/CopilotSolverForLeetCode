class Solution {
    public int[] recoverArray(int n, int[] sums) {
        
        int[] ans = new int[n];
        int[] sums1 = new int[sums.length];
        int[] sums2 = new int[sums.length];
        int[] sums3 = new int[sums.length];
        for (int i = 0; i < sums.length; i++) {
            sums1[i] = sums[i];
            sums2[i] = sums[i];
            sums3[i] = sums[i];
        }
        Arrays.sort(sums1);
        Arrays.sort(sums2);
        Arrays.sort(sums3);
        int sum = 0;
        for (int i = 1; i < sums1.length; i++) {
            sum = sums1[i] - sums1[i - 1];
            if (sum != 0) {
                break;
            }
        }
        ans[0] = sum;
        for (int i = 1; i < sums2.length; i++) {
            if (sums2[i] - sums2[i - 1] != 0) {
                ans[1] = sums2[i] - sums2[i - 1];
                break;
            }
        }
        for (int i = 2; i < n; i++) {
            ans[i] = sums3[i] - sums3[i - 1];
        }
        return ans;
    }
}