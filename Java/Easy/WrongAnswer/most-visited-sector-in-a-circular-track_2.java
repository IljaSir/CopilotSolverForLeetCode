class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        
        int[] count = new int[n];
        int max = 0;
        for (int i = 0; i < rounds.length - 1; i++) {
            int start = rounds[i];
            int end = rounds[i + 1];
            if (start <= end) {
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
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) {
                result.add(i + 1);
            }
        }
        return result;
    }
}