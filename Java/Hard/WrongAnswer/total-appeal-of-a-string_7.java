class Solution {
    public long appealSum(String s) {
        
        long result = 0;
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            int[] seen = new int[26];
            for (int j = i; j < s.length(); j++) {
                int index = s.charAt(j) - 'a';
                if (seen[index] == 0) {
                    count++;
                }
                seen[index]++;
                if (last[index] < i) {
                    result += count;
                    last[index] = j;
                }
            }
        }
        return result;
    }
}