class Solution {
    public int findTheLongestSubstring(String s) {
        
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        int res = 0, status = 0;
        pos[0] = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                status ^= 1 << 0;
            } else if (c == 'e') {
                status ^= 1 << 1;
            } else if (c == 'i') {
                status ^= 1 << 2;
            } else if (c == 'o') {
                status ^= 1 << 3;
            } else if (c == 'u') {
                status ^= 1 << 4;
            }
            if (pos[status] >= 0) {
                res = Math.max(res, i + 1 - pos[status]);
            } else {
                pos[status] = i + 1;
            }
        }
        return res;
    }
}