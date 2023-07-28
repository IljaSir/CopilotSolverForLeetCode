class Solution {
    public String frequencySort(String s) {
        
        if (s == null || s.length() == 0) {
            return s;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> cur = pq.poll();
            for (int i = 0; i < cur.getValue(); i++) {
                sb.append(cur.getKey());
            }
        }
        return sb.toString();
    }
}