class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        
        int[] count = new int[n];
        int max = 0;
        for (int i = 1; i < rounds.length; i++) {
            int start = rounds[i - 1];
            int end = rounds[i];
            if (start < end) {
                for (int j = start; j < end; j++) {
                    count[j - 1]++;
                    max = Math.max(max, count[j - 1]);
                }
            } else {
                for (int j = start; j <= n; j++) {
                    count[j - 1]++;
                    max = Math.max(max, count[j - 1]);
                }
                for (int j = 1; j < end; j++) {
                    count[j - 1]++;
                    max = Math.max(max, count[j - 1]);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (count[i] == max) {
                res.add(i + 1);
            }
        }
        return res;
    }
}