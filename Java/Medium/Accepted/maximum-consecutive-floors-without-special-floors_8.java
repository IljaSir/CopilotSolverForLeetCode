class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        
        Arrays.sort(special);
        int max = 0;
        int len = special.length;
        int last = bottom;
        if (len == 0) {
            return top - bottom + 1;
        }
        for (int i = 0; i < len; i++) {
            int cur = special[i];
            if (cur == last) {
                last = cur + 1;
            } else {
                max = Math.max(max, cur - last);
                last = cur + 1;
            }
        }
        max = Math.max(max, top - last + 1);
        return max;
    }
}