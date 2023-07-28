class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        
        Arrays.sort(special);
        int max = 0;
        int pre = bottom - 1;
        for (int i = 0; i < special.length; i++) {
            if (special[i] == pre + 1) {
                pre = special[i];
                continue;
            }
            max = Math.max(max, special[i] - pre - 1);
            pre = special[i];
        }
        max = Math.max(max, top - pre);
        return max;
    }
}