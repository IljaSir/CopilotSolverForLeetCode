class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        
        int n = s.length();
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (List<Integer> pair : pairs) {
            union(parent, pair.get(0), pair.get(1));
        }
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            PriorityQueue<Character> pq = map.getOrDefault(root, new PriorityQueue<>());
            pq.offer(s.charAt(i));
            map.put(root, pq);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
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
        int rootI = find(parent, i);
        int rootJ = find(parent, j);
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
        }
    }
}