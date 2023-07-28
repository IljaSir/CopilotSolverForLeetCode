class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        
        int n = s.length();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        for (List<Integer> pair : pairs) {
            union(p, pair.get(0), pair.get(1));
        }
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(p, i);
            map.putIfAbsent(root, new PriorityQueue<>());
            map.get(root).add(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int root = find(p, i);
            sb.append(map.get(root).poll());
        }
        return sb.toString();
    }
    private int find(int[] p, int x) {
        if (p[x] != x) {
            p[x] = find(p, p[x]);
        }
        return p[x];
    }
    private void union(int[] p, int x, int y) {
        int rootX = find(p, x);
        int rootY = find(p, y);
        if (rootX != rootY) {
            p[rootX] = rootY;
        }
    }
}