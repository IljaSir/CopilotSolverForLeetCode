class Solution {
    public int largestAltitude(int[] gain) {
        
        int max = 0;
        int cur = 0;
        for (int i = 0; i < gain.length; i++) {
            cur += gain[i];
            max = Math.max(max, cur);
        }
        return max;
    }
}