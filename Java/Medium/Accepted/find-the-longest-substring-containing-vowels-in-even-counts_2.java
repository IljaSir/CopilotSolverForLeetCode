class Solution {
    public int findTheLongestSubstring(String s) {
        
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        pos[0] = 0;
        int ans = 0, status = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                status ^= 1;
            } else if (ch == 'e') {
                status ^= 2;
            } else if (ch == 'i') {
                status ^= 4;
            } else if (ch == 'o') {
                status ^= 8;
            } else if (ch == 'u') {
                status ^= 16;
            }
            if (pos[status] >= 0) {
                ans = Math.max(ans, i + 1 - pos[status]);
            } else {
                pos[status] = i + 1;
            }
        }
        return ans;
    }
}