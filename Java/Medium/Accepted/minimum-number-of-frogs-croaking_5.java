class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        
        int[] count = new int[5];
        int frogs = 0;
        int maxFrogs = 0;
        for (char c : croakOfFrogs.toCharArray()) {
            int index = "croak".indexOf(c);
            count[index]++;
            if (index == 0) {
                frogs++;
                maxFrogs = Math.max(maxFrogs, frogs);
            } else if (index == 4) {
                frogs--;
            } else if (count[index] > count[index - 1]) {
                return -1;
            }
        }
        return frogs == 0 ? maxFrogs : -1;
    }
}