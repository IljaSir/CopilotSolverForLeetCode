class Solution {
    public int rearrangeCharacters(String s, String target) {
        
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int[] targetCount = new int[26];
        for (char c : target.toCharArray()) {
            targetCount[c - 'a']++;
        }
        int[] countCopy = new int[26];
        for (int i = 0; i < 26; i++) {
            countCopy[i] = count[i];
        }
        int res = 0;
        while (true) {
            for (int i = 0; i < 26; i++) {
                count[i] = countCopy[i];
            }
            boolean found = true;
            for (int i = 0; i < 26; i++) {
                if (targetCount[i] > 0 && count[i] == 0) {
                    found = false;
                    break;
                }
            }
            if (!found) {
                break;
            }
            for (int i = 0; i < 26; i++) {
                if (targetCount[i] > 0) {
                    count[i]--;
                }
            }
            res++;
        }
        return res;
    }
}