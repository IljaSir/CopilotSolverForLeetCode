class Solution {
    public int[] shortestToChar(String s, char c) {
        
        int[] result = new int[s.length()];
        int last = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                for (int j = last + 1; j <= i; j++) {
                    result[j] = j - last - 1;
                }
                last = i;
            }
        }
        for (int i = last + 1; i < s.length(); i++) {
            result[i] = i - last - 1;
        }
        return result;
    }
}