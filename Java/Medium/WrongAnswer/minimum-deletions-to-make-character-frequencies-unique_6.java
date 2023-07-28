class Solution {
    public int minDeletions(String s) {
        
        int[] cnts = new int[26];
        for (char c : s.toCharArray()) {
            cnts[c - 'a']++;
        }
        Arrays.sort(cnts);
        int res = 0;
        for (int i = 25; i > 0; i--) {
            if (cnts[i] > 0) {
                if (cnts[i] > cnts[i - 1]) {
                    if (cnts[i - 1] == 0) {
                        cnts[i - 1] = cnts[i] - 1;
                    } else {
                        res += cnts[i] - cnts[i - 1];
                    }
                } else {
                    res += cnts[i];
                }
            }
        }
        return res;
    }
}