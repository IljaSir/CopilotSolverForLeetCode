class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        
        boolean[] result = new boolean[requests.length];
        // build graph
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] r : restrictions) {
            int a = r[0];
            int b = r[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        // build friend
        Set<Integer> friends = new HashSet<>();
        for (int i = 0; i < requests.length; i++) {
            int a = requests[i][0];
            int b = requests[i][1];
            result[i] = isFriend(a, b, graph, friends);
            friends.add(a);
        }
        return result;
    }

    private boolean isFriend(int a, int b, Map<Integer, Set<Integer>> graph, Set<Integer> friends) {
        if (friends.contains(a)) {
            return true;
        }
        if (graph.get(a).contains(b)) {
            return false;
        }
        for (int c : graph.get(a)) {
            if (isFriend(c, b, graph, friends)) {
                return true;
            }
        }
        return false;
    }
}