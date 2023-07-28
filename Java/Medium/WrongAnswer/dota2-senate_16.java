class Solution {
    public String predictPartyVictory(String senate) {
        
        int n = senate.length();
        int[] count = new int[2];
        char[] s = senate.toCharArray();
        int[] ban = new int[n];
        for (int i = 0; i < n; i++) {
            if (s[i] == 'R') {
                count[0]++;
            } else {
                count[1]++;
            }
        }
        int banCount = 0;
        while (banCount < n) {
            for (int i = 0; i < n; i++) {
                if (ban[i] == 0) {
                    if (s[i] == 'R') {
                        if (count[1] == 0) {
                            return "Radiant";
                        }
                        for (int j = i + 1; j < n; j++) {
                            if (s[j] == 'D' && ban[j] == 0) {
                                ban[j] = 1;
                                banCount++;
                                count[1]--;
                                break;
                            }
                        }
                    } else {
                        if (count[0] == 0) {
                            return "Dire";
                        }
                        for (int j = i + 1; j < n; j++) {
                            if (s[j] == 'R' && ban[j] == 0) {
                                ban[j] = 1;
                                banCount++;
                                count[0]--;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return "";
    }
}