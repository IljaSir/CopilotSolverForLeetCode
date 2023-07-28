class Solution {
    public int nextBeautifulNumber(int n) {
        
        int[] count = new int[10];
        String s = Integer.toString(n);
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - '0']++;
        }
        for (int i = 0; i < 10; i++) {
            if (count[i] > i) {
                return -1;
            }
        }
        int[] ans = new int[s.length()];
        int j = 0;
        for (int i = 1; i < 10; i++) {
            while (count[i]-- > 0) {
                ans[j++] = i;
            }
        }
        int res = 0;
        for (int i = 0; i < ans.length; i++) {
            res = res * 10 + ans[i];
        }
        return res;
    }
}