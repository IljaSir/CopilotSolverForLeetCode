class Solution {
    public int maximumGain(String s, int x, int y) {
        
        int score = 0;
        if (x < y) {
            int t = x;
            x = y;
            y = t;
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == 'a') {
                    chars[i] = 'b';
                } else if (chars[i] == 'b') {
                    chars[i] = 'a';
                }
            }
            s = new String(chars);
        }
        int a = 0, b = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                a++;
            } else if (c == 'b') {
                if (a > 0) {
                    a--;
                    score += x;
                } else {
                    b++;
                }
            } else {
                score += Math.min(a, b) * y;
                a = 0;
                b = 0;
            }
        }
        score += Math.min(a, b) * y;
        return score;
    }
}