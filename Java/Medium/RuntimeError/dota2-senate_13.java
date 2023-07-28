class Solution {
    public String predictPartyVictory(String senate) {
        
        int n = senate.length();
        int[] ban = new int[n];
        int[] count = new int[2];
        int banCount = 0;
        for (int i = 0; i < n; i++) {
            count[senate.charAt(i) == 'R' ? 0 : 3]++;
        }
        while (banCount < n) {
            banCount = 0;
            for (int i = 0; i < n; i++) {
                if (ban[i] > 0) {
                    banCount++;
                    continue;
                }
                if (count[senate.charAt(i) == 'R' ? 0 : 1] == 1) {
                    return senate.charAt(i) == 'R' ? "Radiant" : "Dire";
                }
                if (senate.charAt(i) == 'R') {
                    if (count[1] > 0) {
                        ban[i] = 1;
                        count[1]--;
                    } else {
                        count[0]++;
                    }
                } else {
                    if (count[0] > 0) {
                        ban[i] = 1;
                        count[0]--;
                    } else {
                        count[1]++;
                    }
                }
            }
        }
        return "";
    }
}