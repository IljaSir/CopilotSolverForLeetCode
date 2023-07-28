class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        
        int[] ans = new int[queries.length];
        int[][] vowelStringCount = new int[words.length][5];
        int[] vowels = new int[]{'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                for (int k = 0; k < vowels.length; k++) {
                    if (words[i].charAt(j) == vowels[k]) {
                        vowelStringCount[i][k]++;
                    }
                }
            }
        }
        for (int i = 0; i < queries.length; i++) {
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                for (int k = 0; k < vowelStringCount[j].length; k++) {
                    ans[i] += vowelStringCount[j][k];
                }
            }
        }
        return ans;
    }
}