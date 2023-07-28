class Solution {
    public int minimumSwap(String s1, String s2) {
        
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == 'x') {
                x1++;
            } else {
                y1++;
            }
            if (s2.charAt(i) == 'x') {
                x2++;
            } else {
                y2++;
            }
        }
        if ((x1 + x2) % 2 != 0 || (y1 + y2) % 2 != 0) {
            return -1;
        }
        int result = 0;
        if (x1 % 2 != 0) {
            result++;
            x1--;
            y2--;
        }
        if (y1 % 2 != 0) {
            result++;
            y1--;
            x2--;
        }
        result += (x1 + x2) / 2;
        result += (y1 + y2) / 2;
        return result;
    }
}