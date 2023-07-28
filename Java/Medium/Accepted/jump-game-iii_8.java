class Solution {
    public boolean canReach(int[] arr, int start) {
        
        int len = arr.length;
        boolean[] visited = new boolean[len];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int pos = queue.poll();
            if (arr[pos] == 0) {
                return true;
            }
            visited[pos] = true;
            if (pos + arr[pos] < len && !visited[pos + arr[pos]]) {
                queue.add(pos + arr[pos]);
            }
            if (pos - arr[pos] >= 0 && !visited[pos - arr[pos]]) {
                queue.add(pos - arr[pos]);
            }
        }
        return false;
    }
}