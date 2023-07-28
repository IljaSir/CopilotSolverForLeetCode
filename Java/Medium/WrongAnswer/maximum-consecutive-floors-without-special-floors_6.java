class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        
        Arrays.sort(special);
        int max = 0;
        int current = 0;
        int i = 0;
        while (i < special.length && special[i] < bottom) {
            i++;
        }
        if (i == special.length) {
            return top - bottom + 1;
        }
        for (; i < special.length; i++) {
            if (special[i] > top) {
                break;
            }
            if (bottom == special[i]) {
                current = 0;
                bottom++;
            } else {
                current++;
                max = Math.max(max, current);
            }
        }
        if (bottom <= top) {
            max = Math.max(max, top - bottom + 1);
        }
        return max;
    }
}