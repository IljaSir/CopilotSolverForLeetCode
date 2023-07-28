class Solution {
    public boolean canReach(int[] arr, int start) {
        
        boolean[] visited = new boolean[arr.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int index = q.poll();
            if (!visited[index]) {
                visited[index] = true;
                if (arr[index] == 0) return true;
                if (arr[index] + index < arr.length) q.add(arr[index] + index);
                if (index - arr[index] >= 0) q.add(index - arr[index]);
            }
        }
        return false;
    }
}