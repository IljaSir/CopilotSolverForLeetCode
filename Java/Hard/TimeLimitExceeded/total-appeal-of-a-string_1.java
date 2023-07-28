class Solution {
    public long appealSum(String s) {
        
        long result = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] count = new int[26];
            for (int j = i; j < s.length(); j++) {
                count[s.charAt(j) - 'a']++;
                int appeal = 0;
                for (int k = 0; k < 26; k++) {
                    if (count[k] > 0) appeal++;
                }
                result += appeal;
            }
        }
        return result;
    }
}