class Solution {
    public String predictPartyVictory(String senate) {
        
        int n = senate.length();
        int[] arr = new int[n];
        int r = 0, d = 0;
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                arr[i] = 1;
                r++;
            } else {
                arr[i] = -1;
                d++;
            }
        }
        int i = 0;
        int j = 0;
        while (r > 0 && d > 0) {
            if (arr[i] == 1) {
                if (j < 0) {
                    arr[i] = 0;
                    r--;
                    j = 0;
                }
            } else if (arr[i] == -1) {
                if (j > 0) {
                    arr[i] = 0;
                    d--;
                    j = 0;
                }
            }
            if (arr[i] != 0) {
                j += arr[i];
            }
            i = (i + 1) % n;
        }
        if (r > 0) {
            return "Radiant";
        } else {
            return "Dire";
        }
    }
}