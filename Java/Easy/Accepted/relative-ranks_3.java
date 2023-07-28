class Solution {
    public String[] findRelativeRanks(int[] score) {
        
        int n = score.length;
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[i] = score[i];
        }
        Arrays.sort(rank);
        Map<Integer, String> map = new HashMap<>();
        for (int i = n - 1, j = 1; i >= 0; i--, j++) {
            if (j == 1) {
                map.put(rank[i], "Gold Medal");
            } else if (j == 2) {
                map.put(rank[i], "Silver Medal");
            } else if (j == 3) {
                map.put(rank[i], "Bronze Medal");
            } else {
                map.put(rank[i], String.valueOf(j));
            }
        }
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            ans[i] = map.get(score[i]);
        }
        return ans;
    }
}