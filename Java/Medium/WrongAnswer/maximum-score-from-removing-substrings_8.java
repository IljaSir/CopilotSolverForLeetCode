class Solution {
    public int maximumGain(String s, int x, int y) {
        
        int a = 0, b = 0, score = 0;
        char[] arr = s.toCharArray();
        if (x < y) {
            return maximumGain(s, y, x);
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'b') {
                if (a > 0) {
                    a--;
                    score += x;
                } else {
                    b++;
                }
            } else if (arr[i] == 'a') {
                a++;
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