class Solution {
    public int countVowelSubstrings(String word) {
        
        int[] count = new int[5];
        int res = 0;
        for (char c : word.toCharArray()) {
            int index = "aeiou".indexOf(c);
            count[index] = 1;
            if (index > 0) {
                count[index] += count[index - 1];
            }
            res += count[index];
        }
        return res;
    }
}