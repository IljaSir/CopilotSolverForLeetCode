class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        
        boolean[] result = new boolean[requests.length];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] restriction : restrictions) {
            map.get(restriction[0]).add(restriction[1]);
            map.get(restriction[1]).add(restriction[0]);
        }

        for (int i = 0; i < requests.length; i++) {
            int u = requests[i][0];
            int v = requests[i][1];
            if (map.get(u).contains(v)) {
                result[i] = false;
                continue;
            }
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (j == u || j == v) {
                    continue;
                }
                if (map.get(u).contains(j) && map.get(v).contains(j)) {
                    flag = false;
                    break;
                }
            }
            result[i] = flag;
        }
        return result;
    }
}