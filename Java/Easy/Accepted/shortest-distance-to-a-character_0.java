class Solution {
    public int[] shortestToChar(String s, char c) {
        
        int[] result = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                result[i] = 0;
            } else {
                int left = i;
                int right = i;
                while (left >= 0 || right < s.length()) {
                    if (left >= 0 && s.charAt(left) == c) {
                        result[i] = i - left;
                        break;
                    }
                    if (right < s.length() && s.charAt(right) == c) {
                        result[i] = right - i;
                        break;
                    }
                    left--;
                    right++;
                }
            }
        }
        return result;
    }
}