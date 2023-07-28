class Solution {
    public int maxRepOpt1(String text) {
        
        int n = text.length();
        int[] count = new int[26];
        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }
        int ans = 0;
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && text.charAt(j) == text.charAt(i)) {
                j++;
            }
            int cur = j - i;
            if (cur < count[text.charAt(i) - 'a']) {
                cur++;
            }
            ans = Math.max(ans, cur);
            i = j;
        }
        return ans;
    }
}