class Solution {
    public long appealSum(String s) {
        
        long sum = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean[] seen = new boolean[26];
            int count = 0;
            for (int j = i; j < s.length(); j++) {
                if (!seen[s.charAt(j) - 'a']) {
                    seen[s.charAt(j) - 'a'] = true;
                    count++;
                }
                sum += count;
            }
        }
        return sum;
    }
}