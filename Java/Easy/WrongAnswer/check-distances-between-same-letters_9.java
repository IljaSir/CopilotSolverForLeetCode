class Solution {
    public boolean checkDistances(String s, int[] distance) {
        
        int n = s.length();
        int[] count = new int[26];
        int[] first = new int[26];
        int[] last = new int[26];
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            count[index]++;
            if (count[index] == 1) {
                first[index] = i;
            } else {
                last[index] = i;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) {
                continue;
            }
            if (last[i] - first[i] != distance[i]) {
                return false;
            }
        }
        return true;
    }
}