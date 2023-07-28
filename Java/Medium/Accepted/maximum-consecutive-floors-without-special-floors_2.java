class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        
        int max = 0;
        int count = 0;
        Arrays.sort(special);
        for (int i = 0; i < special.length; i++) {
            if (special[i] == bottom) {
                bottom++;
            } else {
                count = special[i] - bottom;
                max = Math.max(max, count);
                bottom = special[i] + 1;
            }
        }
        count = top - bottom + 1;
        max = Math.max(max, count);
        return max;
    }
}