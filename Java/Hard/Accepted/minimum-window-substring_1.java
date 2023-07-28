class Solution {
    public String minWindow(String s, String t) {
        
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int left = 0, right = 0, required = t.length(), formed = 0;
        int[] window = new int[128];
        int[] ans = {-1, 0, 0};
        while (right < s.length()) {
            char c = s.charAt(right);
            window[c]++;
            if (map[c] > 0 && window[c] <= map[c]) {
                formed++;
            }
            while (left <= right && formed == required) {
                c = s.charAt(left);
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                window[c]--;
                if (map[c] > 0 && window[c] < map[c]) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}