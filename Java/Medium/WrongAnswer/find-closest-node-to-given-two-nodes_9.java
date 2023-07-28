class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        
        int n = edges.length;
        int[] level = new int[n];
        Arrays.fill(level, -1);
        int[] parent = new int[n];
        int[] child = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            if (edges[i] != -1) {
                parent[i] = edges[i];
                child[edges[i]] = i;
                size[edges[i]]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node1);
        level[node1] = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == node2) {
                break;
            }
            if (parent[node] != -1 && level[parent[node]] == -1) {
                level[parent[node]] = level[node] + 1;
                queue.add(parent[node]);
            }
            if (child[node] != -1 && level[child[node]] == -1) {
                level[child[node]] = level[node] + 1;
                queue.add(child[node]);
            }
        }
        int min = Integer.MAX_VALUE;
        int result = -1;
        for (int i = 0; i < n; i++) {
            if (level[i] != -1) {
                int max = Math.max(level[i], level[node2]);
                if (max < min) {
                    min = max;
                    result = i;
                }
            }
        }
        return result;
    }
}