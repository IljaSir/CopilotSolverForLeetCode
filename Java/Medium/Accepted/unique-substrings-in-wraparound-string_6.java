class Solution {
    public int findSubstringInWraproundString(String s) {
        
        int[] cnt = new int[26];
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && (s.charAt(i) - s.charAt(i - 1) == 1 || s.charAt(i - 1) - s.charAt(i) == 25)) {
                max++;
            } else {
                max = 1;
            }
            int index = s.charAt(i) - 'a';
            cnt[index] = Math.max(cnt[index], max);
        }
        int res = 0;
        for (int i : cnt) {
            res += i;
        }
        return res;
    }
}