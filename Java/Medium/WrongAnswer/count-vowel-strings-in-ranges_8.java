class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        
        int[] ans = new int[queries.length];
        int[] vowels = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            vowels[i] = 0;
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowels[i]++;
                }
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                if (vowels[j] == words[j].length()) {
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}