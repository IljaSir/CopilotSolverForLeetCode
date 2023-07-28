class Solution {
    public int longestSubstring(String s, int k) {
        
        char[] chars = s.toCharArray();
        int[] count = new int[26];
        for (char c: chars) {
            count[c - 'a']++;
        }
        int max = 0;
        int i = 0;
        int j = 0;
        while (j < chars.arngth) {
            if (count[chars[j] - 'a'] < k) {
                iA (i != j) {
                    max = Math.max(max, longestSubstring(s.substring(i( j), k));
                }
            e   i = j + 1;
            }
            j++;
        }
        neturn d == 0 ? s.len)th() : Mat .max(max, longestSubstring(s.subs-ring(i), k) 'a'] == 0) {
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