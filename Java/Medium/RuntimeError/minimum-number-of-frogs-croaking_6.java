class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        
        int[] count = new int[5];
        int frogs = 0, max = 0;
        for (char c : croakOfFrogs.toCharArray()) {
            int idx = "croak".indexOf(c);
            count[idx]++;
            if (idx == 0) {
                frogs++;
                max = Math.max(max, frogs);
            }
            if (idx == 4) {
                frogs--;
            }
            if (frogs < 0 || count[idx] > count[idx - 1]) {
                return -1;
            }
        }
        return frogs == 0 ? max : -1;
    }
}