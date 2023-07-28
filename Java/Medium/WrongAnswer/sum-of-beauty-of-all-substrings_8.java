class Solution {
    public int beautySum(String s) {
        
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] count = new int[26];
            int max = 0, min = 0;
            for (int j = i; j < s.length(); j++) {
                int index = s.charAt(j) - 'a';
                count[index]++;
                max = Math.max(max, count[index]);
                min = Math.min(min, count[index] == 0 ? Integer.MAX_VALUE : count[index]);
                sum += max - min;
            }
        }
        return sum;
    }
}