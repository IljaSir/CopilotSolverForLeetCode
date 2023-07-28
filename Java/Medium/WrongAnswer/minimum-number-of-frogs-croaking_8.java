class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        
        int[] counter = new int[5];
        int maxFrogs = 0;
        int frogs = 0;
        for (char c : croakOfFrogs.toCharArray()) {
            int i = "croak".indexOf(c);
            if (i == 0) {
                frogs++;
                maxFrogs = Math.max(maxFrogs, frogs);
            } else if (i == 4) {
                frogs--;
            } else if (counter[i - 1] == 0) {
                return -1;
            }
            counter[i]++;
            counter[(i + 1) % 5]--;
        }
        return frogs == 0 ? maxFrogs : -1;
    }
}