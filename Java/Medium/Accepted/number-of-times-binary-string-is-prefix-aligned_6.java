class Solution {
    public int numTimesAllBlue(int[] flips) {
        
        int n = flips.length;
        int max = flips[0];
        int ans = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, flips[i]);
            if(max == i + 1) ans++;
        }
        return ans;
    }
}