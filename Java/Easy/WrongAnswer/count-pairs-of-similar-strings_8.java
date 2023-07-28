class Solution {
    public int similarPairs(String[] words) {
        
        int len = words.length;
        int[][] map = new int[26][26];
        int count = 0;
        for (String word : words) {
            int[] charMap = new int[26];
            for (char c : word.toCharArray()) {
                charMap[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (charMap[i] > 0) {
                    for (int j = 0; j < 26; j++) {
                        if (i != j && charMap[j] > 0) {
                            count += map[i][j];
                            map[j][i]++;
                        }
                    }
                }
            }
        }
        return count;
    }
}