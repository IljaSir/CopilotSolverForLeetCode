class Solution {
    public int nextBeautifulNumber(int n) {
        
        String s = String.valueOf(n);
        int[] count = new int[10];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - '0']++;
        }
        int[] res = new int[s.length()];
        int i = 0;
        for (int j = 1; j <= 9; j++) {
            if (count[j] > 0) {
                res[i++] = j;
                count[j]--;
            }
        }
        for (int j = 0; j <= 9; j++) {
            while (count[j] > 0) {
                res[i++] = j;
                count[j]--;
            }
        }
        int ans = 0;
        for (int j = 0; j < res.length; j++) {
            ans = ans * 10 + res[j];
        }
        return ans;
    }
}