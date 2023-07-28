class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(new ArrayList<>());
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (!map.containsKey(edges[i][1])) {
                map.put(edges[i][1], new ArrayList<>());
            }
            map.get(edges[i][1]).add(edges[i][0]);
        }
        for (int i = 0; i < n; i++) {
            getAncestors(i, map, result);
        }
        return result;
    }
    public void getAncestors(int node, Map<Integer, List<Integer>> map, List<List<Integer>> result) {
        if (map.containsKey(node)) {
            List<Integer> list = map.get(node);
            for (int i = 0; i < list.size(); i++) {
                int val = list.get(i);
                result.get(node).add(val);
                getAncestors(val, map, result);
            }
        }
    }
}