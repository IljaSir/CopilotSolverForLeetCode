class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (first[s.charAt(i) - 'a'] == -1) {
                first[s.charAt(i) - 'a'] = i;
            }
            last[s.charAt(i) - 'a'] = i;
        }
        int res = -1;
        for (int i = 0; i < 26; i++) {
            if (first[i] != -1 && last[i] != -1) {
                res = Math.max(res, last[i] - first[i] - 1);
            }
        }
        return res;
    }
}