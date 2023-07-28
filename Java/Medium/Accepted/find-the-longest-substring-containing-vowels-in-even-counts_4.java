class Solution {
    public int findTheLongestSubstring(String s) {
        
        int[] first = new int[32];
        Arrays.fill(first, -1);
        int n = s.length();
        int cur = 0;
        int max = 0;
        first[0] = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                cur ^= 1;
            } else if (c == 'e') {
                cur ^= 2;
            } else if (c == 'i') {
                cur ^= 4;
            } else if (c == 'o') {
                cur ^= 8;
            } else if (c == 'u') {
                cur ^= 16;
            }
            if (first[cur] != -1) {
                max = Math.max(max, i + 1 - first[cur]);
            } else {
                first[cur] = i + 1;
            }
        }
        return max;
    }
}