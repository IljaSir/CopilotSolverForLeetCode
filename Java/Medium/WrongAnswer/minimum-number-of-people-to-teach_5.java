class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        
        int m = languages.length;
        int[] languageCount = new int[n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < languages[i].length; j++) {
                languageCount[languages[i][j]]++;
            }
        }
        int[] languageCount2 = languageCount.clone();
        int[] languageCount3 = languageCount.clone();
        for (int i = 0; i < friendships.length; i++) {
            int[] friendship = friendships[i];
            int a = friendship[0];
            int b = friendship[1];
            boolean flag = false;
            for (int j = 0; j < languages[a - 1].length; j++) {
                if (Arrays.binarySearch(languages[b - 1], languages[a - 1][j]) >= 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                for (int j = 0; j < languages[a - 1].length; j++) {
                    languageCount2[languages[a - 1][j]]--;
                }
                for (int j = 0; j < languages[b - 1].length; j++) {
                    languageCount3[languages[b - 1][j]]--;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            min = Math.min(min, Math.min(languageCount2[i], languageCount3[i]));
        }
        return min;
    }
}