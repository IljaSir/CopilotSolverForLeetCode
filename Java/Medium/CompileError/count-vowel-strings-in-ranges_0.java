class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                if (isVowel(words[j])) {
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}