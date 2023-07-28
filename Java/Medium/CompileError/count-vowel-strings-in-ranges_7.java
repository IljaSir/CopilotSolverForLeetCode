class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        
        int[] ans = new int[queries.length];
        int[] vowelCount = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int count = 0;
            for (int j = 0; j < words[i].length(); j++) {
                if (isVowel(words[i].charAt(j))) {
                    count++;
                }
            }
            vowelCount[i] = count;
        }
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                count += vowelCount[j];
            }
            ans[i] = count;
        }
        return ans;
    }
}