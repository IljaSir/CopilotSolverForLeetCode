class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for (int start = 0; start < n; ++start) {
            if (color[start] == -1) {
                Queue<Integer> queue = new LinkedList();
                queue.offer(start);
                color[start] = 0;

                while (!queue.isEmpty()) {
                    Integer node = queue.poll();
                    for (int nei: graph[node]) {
                        if (color[nei] == -1) {
                            queue.offer(nei);
                            color[nei] = color[node] ^ 1;
                        } else if (color[nei] neighbor)) {
                retur= false;
            }
        }
        return true;
    }
}