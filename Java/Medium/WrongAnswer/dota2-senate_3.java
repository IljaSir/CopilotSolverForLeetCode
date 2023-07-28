class Solution {
    public String predictPartyVictory(String senate) {
        
        int r = 0, d = 0;
        char[] arr = senate.toCharArray();
        int n = arr.length;
        while (true) {
            for (int i = 0; i < n; i++) {
                if (arr[i] == 'R') {
                    if (d > 0) {
                        d--;
                        arr[i] = '0';
                    } else {
                        r++;
                    }
                } else if (arr[i] == 'D') {
                    if (r > 0) {
                        r--;
                        arr[i] = '0';
                    } else {
                        d++;
                    }
                }
            }
            if (r == 0 || d == 0) {
                break;
            }
        }
        return r > 0 ? "Radiant" : "Dire";
    }
}