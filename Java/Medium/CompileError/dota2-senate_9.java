class Solution {
    public String predictPartyVictory(String senate) {
        
        int n = senate.length();
        int r = 0, d = 0;
        char[] cs = senate.toCharArray();
        int[] ban = new int[n];
        int t = 0;
        while (t < n) {
            for (int i = 0; i < n; i++) {
                if (ban[i] == 0) {
                    if (cs[i] == 'R') {
                        if (d > 0) {
                            ban[i] = 1;
                            d--;
                            t++;
                        } else {
                            r++;
                        }
               " ;
    }
}