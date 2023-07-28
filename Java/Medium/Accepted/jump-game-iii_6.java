class Solution {
    public boolean canReach(int[] arr, int start) {
        
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int i = q.remove();
            if (arr[i] == 0) {
                return true;
            }
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            if (i + arr[i] < n) {
                q.add(i + arr[i]);
            }
            if (i - arr[i] >= 0) {
                q.add(i - arr[i]);
            }
        }
        return false;
    }
}