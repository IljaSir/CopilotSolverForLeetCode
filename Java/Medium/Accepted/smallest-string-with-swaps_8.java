class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        
        int n = s.length();
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
        for (List<Integer> pair : pairs) {
            int x = pair.get(0), y = pair.get(1);
            f[find(x, f)] = find(y, f);
        }
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int fa = find(i, f);
            PriorityQueue<Character> queue = map.getOrDefault(fa, new PriorityQueue<>());
            queue.offer(s.charAt(i));
            map.put(fa, queue);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int fa = find(i, f);
            sb.append(map.get(fa).poll());
        }
        return sb.toString();
    }

    private int find(int x, int[] f) {
        if (f[x] != x) {
            f[x] = find(f[x], f);
        }
        return f[x];
    }
}