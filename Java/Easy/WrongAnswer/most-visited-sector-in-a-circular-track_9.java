class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        
        List<Integer> res = new ArrayList<>();
        int[] count = new int[n];
        int max = 0;
        int start = rounds[0];
        int end = rounds[rounds.length - 1];
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                count[i - 1]++;
                max = Math.max(max, count[i - 1]);
            }
        } else {
            for (int i = 0; i < start; i++) {
                count[i]++;
                max = Math.max(max, count[i]);
            }
            for (int i = end; i < n; i++) {
                count[i]++;
                max = Math.max(max, count[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (count[i] == max) {
                res.add(i + 1);
            }
        }
        return res;
    }
}