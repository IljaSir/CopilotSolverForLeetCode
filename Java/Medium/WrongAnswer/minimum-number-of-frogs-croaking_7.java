class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        
        int[] count = new int[5];
        int res = 0;
        int curr = 0;
        for (char c: croakOfFrogs.toCharArray()) {
            int i = "croak".indexOf(c);
            if (i == -1) return -1;
            if (i == 0) {
                curr++;
                res = Math.max(res, curr);
            } else if (count[i - 1] == 0) {
                return -1;
            } else {
                count[i - 1]--;
                curr--;
            }
            count[i]++;
        }
        return curr == 0 ? res : -1;
    }
}