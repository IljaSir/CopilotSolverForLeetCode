class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        
        int[] count = new int[n];
        int max = 0;
        for (int i = 0; i < rounds.length - 1; i++) {
            int start = rounds[i] - 1;
            int end = rounds[i + 1] - 1;
            if (start < end) {
                for (int j = start; j < end; j++)
                    max = Math.max(max, ++count[j]);
            } else {
                for (int j = start; j < n; j++)
                    max = Math.max(max, ++count[j]);
                for (int j = 0; j < end; j++)
                    max = Math.max(max, ++count[j]);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (count[i] == max)
                res.add(i + 1);
        }
        return res;
    }
}