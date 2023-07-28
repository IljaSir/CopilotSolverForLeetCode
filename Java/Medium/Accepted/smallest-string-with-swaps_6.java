class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        
        int[] parent = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            parent[i] = i;
        }
        for (List<Integer> pair : pairs) {
            int p1 = find(parent, pair.get(0));
            int p2 = find(parent, pair.get(1));
            if (p1 != p2) {
                parent[p1] = p2;
            }
        }
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int p = find(parent, i);
            map.putIfAbsent(p, new PriorityQueue<>());
            map.get(p).offer(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int p = find(parent, i);
            sb.append(map.get(p).poll());
        }
        return sb.toString();
    }
    private int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent, parent[i]);
    }
}