class Solution {
    public int[] recoverArray(int n, int[] sums) {
        
        int[] ans = new int[n];
        Arrays.sort(sums);
        for(int i=0; i<n; i++) {
            ans[i] = sums[sums.length-1] - sums[sums.length-2];
            for(int j=0; j<sums.length-2; j++) {
                sums[j] -= ans[i];
            }
            Arrays.sort(sums);
        }
        return ans;
    }
}