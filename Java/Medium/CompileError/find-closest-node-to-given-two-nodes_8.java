class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        
        int[] visited = new int[edges.length];
        int[] distance = new int[edges.length];
        int[] parent = new int[edges.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node1);
        visited[node1] = 1;
        int minDistance = Integer.MAX_VALUE;
        int minIndex = -1;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 0; i < edges.length; i++) {
                if (edges[i] == node) {
                    if (visited[i] == 0) {
                        visited[i] = 1;
                        distance[i] = distance[node] + 1;
                        parent[i] = node;
                        if (i == node2) {
                            if (distance[i] < minDistance) {
                                minDistance = distance[i];
                                minIndex = i;
                            }
                        }
                        queue.add(i);
                    }
                }
            }
        }
        if (minIndex == -1) {
            return -1;
        }
        int node = minIndex;
        while (node != node1) {
            node = parent[node];
        }
        return node;
    }
}
    }
}