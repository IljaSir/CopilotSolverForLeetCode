class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        
        int n = s.length();
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (List<Integer> pair : pairs) {
            int root1 = find(parent, pair.get(0));
            int root2 = find(parent, pair.get(1));
            if (root1 != root2) {
                parent[root1] = root2;
            }
        }
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            PriorityQueue<Character> queue = map.getOrDefault(root, new PriorityQueue<>());
            queue.offer(s.charAt(i));
            map.put(root, queue);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int root = find(parent, i);
            sb.append(map.get(root).poll());
        }
        return sb.toString();
    }

    private int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }
}