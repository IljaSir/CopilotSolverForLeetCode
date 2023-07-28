class Solution {
    public int secondHighest(String s) {
        
        int max = -1;
        int secondMax = -1;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int n = c - '0';
                if (n > max) {
                    secondMax = max;
                    max = n;
                } else if (n > secondMax && n != max) {
                    secondMax = n;
                }
            }
        }
        return secondMax;
    }
}