class Solution {
    public long appealSum(String s) {
        
        long res = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int[] count = new int[26];
            for (int j = i; j < n; j++) {
                int idx = s.charAt(j) - 'a';
                if (count[idx] == 0) {
                    res += 1;
                }
                count[idx]++;
            }
        }
        return res;
    }
}