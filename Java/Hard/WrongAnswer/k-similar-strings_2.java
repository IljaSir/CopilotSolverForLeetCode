class Solution {
    public int kSimilarity(String s1, String s2) {
        
        if (s1.equals(s2)) {
            return 0;
        }
        int n = s1.length();
        int[] pos = new int[26];
        for (int i = 0; i < n; i++) {
            pos[s1.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                int j = pos[s2.charAt(i) - 'a'];
                char[] ch = s1.toCharArray();
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
                pos[s1.charAt(i) - 'a'] = j;
                pos[s2.charAt(i) - 'a'] = i;
                s1 = String.valueOf(ch);
                break;
            }
        }
        return 1 + kSimilarity(s1, s2);
    }
}