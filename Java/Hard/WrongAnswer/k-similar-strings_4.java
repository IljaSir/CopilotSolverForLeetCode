class Solution {
    public int kSimilarity(String s1, String s2) {
        
        int n = s1.length();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        int ans = 0;
        while (!s1.equals(s2)) {
            int i = 0;
            while (s1.charAt(i) == s2.charAt(i)) {
                i++;
            }
            int j = i + 1;
            while (s1.charAt(j) != s2.charAt(i)) {
                j++;
            }
            char[] chars = s1.toCharArray();
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            s1 = String.valueOf(chars);
            ans++;
        }
        return ans;
    }
}