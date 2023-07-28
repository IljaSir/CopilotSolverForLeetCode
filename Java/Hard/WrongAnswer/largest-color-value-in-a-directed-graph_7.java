class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        
        int n = colors.length();
        int[] inDegree = new int[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];
            inDegree[to]++;
            List<Integer> list = graph.getOrDefault(from, new ArrayList<>());
            list.add(to);
            graph.put(from, list);
        }
        int[] colorCount = new int[26];
        int[] colorCountCopy = new int[26];
        int maxCount = 0;
        int[] colorCountMax = new int[26];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < 26; i++) {
                colorCountCopy[i] = colorCount[i];
            }
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                int color = colors.charAt(node) - 'a';
                colorCount[color]++;
                if (colorCount[color] > maxCount) {
                    maxCount = colorCount[color];
                    for (int j = 0; j < 26; j++) {
                        colorCountMax[j] = colorCount[j];
                    }
                }
                if (graph.containsKey(node)) {
                    for (int next: graph.get(node)) {
                        inDegree[next]--;
                        if (inDegree[next] == 0) {
                            queue.offer(next);
                        }
                    }
                }
            }
            for (int i = 0; i < 26; i++) {
                colorCount[i] = colorCountCopy[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (inDegree[i] > 0) {
                return -1;
            }
        }
        return maxCount;
    }
}