class Solution {
    public String predictPartyVictory(String senate) {
        
        int n = senate.length();
        int[] count = new int[2];
        boolean[] ban = new boolean[n];
        for (int i = 0; i < n; i++) {
            count[senate.charAt(i) == 'R' ? 0 : 1]++;
        }
        while (count[0] > 0 && count[1] > 0) {
            for (int i = 0; i < n; i++) {
                if (ban[i]) {
                    continue;
                }
                int x = senate.charAt(i) == 'R' ? 0 : 1;
                if (count[x ^ 1] > 0) {
                    ban[i] = true;
                    count[x ^ 1]--;
                } else {
                    count[x]++;
                }
            }
        }
        return count[0] > 0 ? "Radiant" : "Dire";
    }
}