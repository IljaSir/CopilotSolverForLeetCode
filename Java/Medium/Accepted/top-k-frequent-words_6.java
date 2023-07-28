class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> map.get(a).equals(map.get(b)) ? b.compareTo(a) : map.get(a) - map.get(b));
        for (String s : map.keySet()) {
            pq.offer(s);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }
        Collections.reverse(res);
        return res;
    }
}