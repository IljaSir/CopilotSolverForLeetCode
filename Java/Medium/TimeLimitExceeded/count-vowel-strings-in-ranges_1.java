class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int count = 0;
            for (int j = start; j <= end; j++) {
                if (words[j].charAt(0) == 'a' || words[j].charAt(0) == 'e' || words[j].charAt(0) == 'i' || words[j].charAt(0) == 'o' || words[j].charAt(0) == 'u') {
                    if (words[j].charAt(words[j].length() - 1) == 'a' || words[j].charAt(words[j].length() - 1) == 'e' || words[j].charAt(words[j].length() - 1) == 'i' || words[j].charAt(words[j].length() - 1) == 'o' || words[j].charAt(words[j].length() - 1) == 'u') {
                        count++;
                    }
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}