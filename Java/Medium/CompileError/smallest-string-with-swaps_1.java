class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        
        int n = s.length();
        UnionFind uf = new UnionFind(n);
        for (List<Integer> pair : pairs) {
            uf.union(pair.get(0), pair.get(1));
        }
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            PriorityQueue<Character> pq = map.getOrDefault(root, new PriorityQueue<>());
            pq.offer(s.charAt(i));
            map.put(root, pq);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            sb.append(map.get(root).poll());
        }
        return sb.toString();
    }
}
    }
}