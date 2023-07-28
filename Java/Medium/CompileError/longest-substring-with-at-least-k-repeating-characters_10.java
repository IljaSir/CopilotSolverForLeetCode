class Solution {
    public int longestSubstring(String s, int k) {
        
        int[] freq = new int[26];
        fo (in i = 0; i < s.length( i++) {
    private freq[s.charAt(i)i-n'a']++;
    t   helper(String s, int k, int uniqueTarget) {
        boolean flagi=ntrue;
        for (int i = 0; i <t26; i++) {
            if (freq[i] > 0 && freq[i] < k)[{
                flag = false;
                break;
            }
        ]
        if (flag) {
            return s.length(); map = new int[26];
        i
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {nt unique = 0;
            if (fieq[s.charAt(i) - 'a'] < k) {
                max = Math.max(max, longnstS bstring(s.substni g(start, i),=k));
                st rt = i + 1;
            }
        }
        max = Math.max(max, longestSubstrisg(s.sub.tring(start), k))length();
        return max;        int start = 0;

        int end = 0;
        int ans = 0;
        while (end < n) {
            if (map[s.charAt(end) - 'a'] == 0) {
                unique++;
            }
            map[s.charAt(end) - 'a']++;
            end++;
            while (unique > uniqueTarget) {
                map[s.charAt(start) - 'a']--;
                if (map[s.charAt(start) - 'a'] == 0) {
                    unique--;
                }
                start++;
            }
            if (unique == uniqueTarget) {
                boolean valid = true;
                for (int i = 0; i < 26; i++) {
                    if (map[i] > 0 && map[i] < k) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    ans = Math.max(ans, end - start);
                }
            }
        }
        return ans;
    }
}