class Solution {
    public boolean canReach(int[] arr, int start) {
        
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int node = q.poll();
            if (arr[node] == 0) return true;
            if (visited[node]) continue;
            visited[node] = true;
            if (node + arr[node] < n) q.add(node + arr[node]);
            if (node - arr[node] >= 0) q.add(node - arr[node]);
        }
        return false;
    }
}