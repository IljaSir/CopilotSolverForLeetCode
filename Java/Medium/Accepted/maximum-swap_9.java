class Solution {
    public int maximumSwap(int num) {
        
        char[] chars = String.valueOf(num).toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < chars.length; i++) {
            last[chars[i] - '0'] = i;
        }
        for (int i = 0; i < chars.length; i++) {
            for (int d = 9; d > chars[i] - '0'; d--) {
                if (last[d] > i) {
                    char tmp = chars[i];
                    chars[i] = chars[last[d]];
                    chars[last[d]] = tmp;
                    return Integer.valueOf(new String(chars));
                }
            }
        }
        return num;
    }
}