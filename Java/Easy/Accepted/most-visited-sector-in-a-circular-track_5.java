class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        
        int[] counter = new int[n];
        int start = rounds[0] - 1;
        int end = rounds[rounds.length - 1] - 1;
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                counter[i]++;
            }
        } else {
            for (int i = 0; i <= end; i++) {
                counter[i]++;
            }
            for (int i = start; i < n; i++) {
                counter[i]++;
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, counter[i]);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (counter[i] == max) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}