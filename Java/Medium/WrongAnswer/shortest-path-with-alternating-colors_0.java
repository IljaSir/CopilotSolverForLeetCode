class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        Map<Integer, List<Integer>> redMap = new HashMap<>();
        Map<Integer, List<Integer>> blueMap = new HashMap<>();
        for (int[] edge : redEdges) {
            if (!redMap.containsKey(edge[0])) {
                redMap.put(edge[0], new ArrayList<>());
            }
            redMap.get(edge[0]).add(edge[1]);
        }
        for (int[] edge : blueEdges) {
            if (!blueMap.containsKey(edge[0])) {
                blueMap.put(edge[0], new ArrayList<>());
            }
            blueMap.get(edge[0]).add(edge[1]);
        }
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int step = 0;
        Set<Integer> redVisited = new HashSet<>();
        Set<Integer> blueVisited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                if (result[node] == -1) {
                    result[node] = step;
                }
                if (redVisited.contains(node)) {
                    if (blueMap.containsKey(node)) {
                        for (int next : blueMap.get(node)) {
                            if (!blueVisited.contains(next)) {
                                blueVisited.add(next);
                                queue.offer(next);
                            }
                        }
                    }
                } else if (blueVisited.contains(node)) {
                    if (redMap.containsKey(node)) {
                        for (int next : redMap.get(node)) {
                            if (!redVisited.contains(next)) {
                                redVisited.add(next);
                                queue.offer(next);
                            }
                        }
                    }
                } else {
                    if (redMap.containsKey(node)) {
                        for (int next : redMap.get(node)) {
                            if (!redVisited.contains(next)) {
                                redVisited.add(next);
                                queue.offer(next);
                            }
                        }
                    }
                    if (blueMap.containsKey(node)) {
                        for (int next : blueMap.get(node)) {
                            if (!blueVisited.contains(next)) {
                                blueVisited.add(next);
                                queue.offer(next);
                            }
                        }
                    }
                }
            }
            step++;
        }
        return result;
    }
}