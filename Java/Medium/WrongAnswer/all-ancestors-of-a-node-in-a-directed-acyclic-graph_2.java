class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        
        List<List<Integer>> ancestors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ancestors.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            ancestors.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            List<Integer> ancestor = ancestors.get(i);
            for (int j = 0; j < ancestor.size(); j++) {
                ancestor.addAll(ancestors.get(ancestor.get(j)));
            }
            Collections.sort(ancestor);
        }
        return ancestors;
    }
}