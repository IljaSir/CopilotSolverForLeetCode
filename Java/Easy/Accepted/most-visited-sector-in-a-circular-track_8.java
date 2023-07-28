class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        
        List<Integer> ans = new ArrayList<Integer>();
        int[] visited = new int[n];
        int start = rounds[0] - 1;
        int end = rounds[rounds.length - 1] - 1;
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                visited[i]++;
            }
        } else {
            for (int i = 0; i <= end; i++) {
                visited[i]++;
            }
            for (int i = start; i < n; i++) {
                visited[i]++;
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, visited[i]);
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == max) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}