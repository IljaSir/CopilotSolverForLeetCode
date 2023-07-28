class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        
        Arrays.sort(special);
        int max = 0;
        for (int i = 0; i < special.length; i++) {
            if (i == 0) {
                max = Math.max(max, special[i] - bottom);
            } else {
                max = Math.max(max, special[i] - special[i - 1] - 1);
            }
        }
        if (special.length > 0) {
            max = Math.max(max, top - special[special.length - 1]);
        } else {
            max = Math.max(max, top - bottom + 1);
        }
        return max;
    }
}