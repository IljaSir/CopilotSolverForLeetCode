class Solution {
    public int maxRepOpt1(String text) {
        
        int[] count = new int[26];
        int[] last = new int[26];
        for (int i = 0; i < text.length(); i++) {
            count[text.charAt(i) - 'a']++;
            last[text.charAt(i) - 'a'] = i;
        }
        int max = 0;
        for (int i = 0; i < text.length(); i++) {
            int c = text.charAt(i) - 'a';
            int j = i;
            while (j < text.length() && (text.charAt(j) - 'a') == c) j++;
            int k = j;
            while (k < text.length() && (text.charAt(k) - 'a') == c) k++;
            int l = i;
            while (l >= 0 && (text.charAt(l) - 'a') == c) l--;
            int m = l;
            while (m >= 0 && (text.charAt(m) - 'a') == c) m--;
            int len = j - i;
            if (j - l - 1 > 0 && j - l - 1 <= count[c]) len += j - l - 1;
            else if (k - i - 1 > 0 && k - i - 1 <= count[c]) len += k - i - 1;
            else if (k - i - 1 > 0 && k - i - 1 <= count[c] + 1) len += k - i - 1;
            max = Math.max(max, len);
            i = j - 1;
        }
        return max;
    }
}