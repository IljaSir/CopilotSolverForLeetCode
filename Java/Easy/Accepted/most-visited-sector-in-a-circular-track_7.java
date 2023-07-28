class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        
        int[] visited = new int[n];
        int start = rounds[0] - 1;
        int end = rounds[rounds.length - 1] - 1;
        if(start <= end) {
            for(int i = start; i <= end; i++) {
                visited[i] = 1;
            }
        } else {
            for(int i = 0; i <= end; i++) {
                visited[i] = 1;
            }
            for(int i = start; i < n; i++) {
                visited[i] = 1;
            }
        }
        List<Integer> res = new ArrayList<>();
        int max = 0;
        for(int i = 0; i < n; i++) {
            if(visited[i] == 1) {
                res.add(i+1);
                max++;
            }
        }
        return res;
    }
}