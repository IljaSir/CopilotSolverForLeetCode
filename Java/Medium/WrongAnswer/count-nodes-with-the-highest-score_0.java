class Solution {
    public int countHighestScoreNodes(int[] parents) {
        
        int n = parents.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(parents[i], new ArrayList<>());
            map.get(parents[i]).add(i);
        }
        int[] count = new int[n];
        int[] score = new int[n];
        int maxScore = 0;
        int maxCount = 0;
        for (int i = n - 1; i >= 0; i--) {
            int nodeScore = 1;
            for (int child : map.getOrDefault(i, new ArrayList<>())) {
                nodeScore *= (score[child] + 1);
            }
            score[i] = nodeScore;
            if (nodeScore > maxScore) {
                maxScore = nodeScore;
                maxCount = 1;
            } else if (nodeScore == maxScore) {
                maxCount++;
            }
        }
        return maxCount;
    }
}