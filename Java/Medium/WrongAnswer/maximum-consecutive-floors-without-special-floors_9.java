class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        
        int n = special.length;
        int max = 0;
        int prev = bottom - 1;
        for(int i = 0; i <= n; i++){
            int curr = i == n ? top + 1 : special[i];
            max = Math.max(max, curr - prev - 1);
            prev = curr;
        }
        return max;
    }
}