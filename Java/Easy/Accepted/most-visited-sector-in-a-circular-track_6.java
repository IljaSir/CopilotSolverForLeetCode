class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        
        int[] count = new int[n+1];
        for (int i=0; i<rounds.length-1; i++) {
            int start = rounds[i];
            int end = rounds[i+1];
            if (start < end) {
                for (int j=start; j<end; j++) {
                    count[j]++;
                }
            } else {
                for (int j=start; j<=n; j++) {
                    count[j]++;
                }
                for (int j=1; j<end; j++) {
                    count[j]++;
                }
            }
        }
        count[rounds[rounds.length-1]]++;
        int max = 0;
        for (int i=1; i<=n; i++) {
            max = Math.max(max, count[i]);
        }
        List<Integer> result = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            if (count[i] == max) {
                result.add(i);
            }
        }
        return result;
    }
}