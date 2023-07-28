class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        
        List<Integer> result = new ArrayList<>();
        result.add(firstPerson);
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<Integer>());
        }
        for (int[] meeting : meetings) {
            graph.get(meeting[0]).add(meeting[1]);
            graph.get(meeting[1]).add(meeting[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(firstPerson);
        Set<Integer> visited = new HashSet<>();
        visited.add(firstPerson);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    result.add(neighbor);
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}