class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        
        Arrays.sort(special);
        int max = 0;
        int prev = bottom - 1;
        for (int i = 0; i < special.length; i++) {
            max = Math.max(max, special[i] - prev - 1);
            prev = special[i];
        }
        max = Math.max(max, top - prev);
        return max;
    }
}