class Solution {
    public long appealSum(String s) {
        
        long totalAppeal = 0;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int distinct = 0;
            Arrays.fill(count, 0);
            for (int j = i; j < s.length(); j++) {
                if (count[s.charAt(j) - 'a'] == 0) {
                    distinct++;
                    count[s.charAt(j) - 'a'] = 1;
                }
                totalAppeal += distinct;
            }
        }
        return totalAppeal;
    }
}