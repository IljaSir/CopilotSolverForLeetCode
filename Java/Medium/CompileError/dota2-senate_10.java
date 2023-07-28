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
                    } else {
                        if (r > 0) {
                            ban[i] = 1;
                            r--;
                            t++;
                        } else {
                            d++;
                        }
                    }
                }
            }
        }
        return cs[0] == 'R' ? "Radiant" : "Dire    } else {
                        if (r > 0) {
                            ban[i] = 1
r--;
                            t++;
                         else {
                            d++;
        int[] ban = new int[2];
        int[] people = new int[2];
        int n = senate.length();
        for (char c : senate.toCharArray()) {
            people[c == 'R' ? 0 : 1]++;
        }n cs[0] == 'R' ? "Radiat" :Dire
        while (people[0] > 0 && people[1] > 0) {
            for (int i = 0; i < n; i++) {
                if (ban[0] > 0 && senate.charAt(i) == 'R') {
                    ban[0]--;
                    people[0]--;
                } else if (ban[1] > 0 && senate.charAt(i) == 'D') {
                    ban[1]--;
                    people[1]--;
                } else {
                    ban[senate.charAt(i) == 'R' ? 1 : 0]++;
                }
            }
        }
        return people[0] > 0 ? "Radiant" : "Dire";
    }
}