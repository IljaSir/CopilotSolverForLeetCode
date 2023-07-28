class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        
        int n = s.length();
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (List<Integer> pair : pairs) {
            int x = pair.get(0);
            int y = pair.get(1);
            union(parent, x, y);
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
            PriorityQueue<Character> pq = map.get(root);
            sb.append(pq.poll());
        }

        return sb.toString();
    }

    private void union(int[] parent, int x, int y) {
        int px = find(parent, x);
        int py = find(parent, y);
        if (px != py) {
            parent[px] = py;
        }
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}