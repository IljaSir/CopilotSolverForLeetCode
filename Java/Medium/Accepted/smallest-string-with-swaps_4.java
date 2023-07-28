class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        
        int[] parent = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            parent[i] = i;
        }
        for (List<Integer> pair : pairs) {
            union(parent, pair.get(0), pair.get(1));
        }
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int root = find(parent, i);
            map.computeIfAbsent(root, x -> new PriorityQueue()).add(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int root = find(parent, i);
            sb.append(map.get(root).poll());
        }
        return sb.toString();
    }
    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
    private void union(int[] parent, int i, int j) {
        int root1 = find(parent, i);
        int root2 = find(parent, j);
        if (root1 != root2) {
            parent[root1] = root2;
        }
    }
}