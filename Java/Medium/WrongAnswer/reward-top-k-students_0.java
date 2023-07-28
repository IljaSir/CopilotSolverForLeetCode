class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        
        Set<String> positive = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> negative = new HashSet<>(Arrays.asList(negative_feedback));
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < report.length; i++) {
            String[] words = report[i].split(" ");
            int id = student_id[i];
            for (String word : words) {
                if (positive.contains(word)) {
                    map.put(id, map.getOrDefault(id, 0) + 3);
                } else if (negative.contains(word)) {
                    map.put(id, map.getOrDefault(id, 0) - 1);
                }
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) != map.get(b) ? map.get(a) - map.get(b) : b - a);
        for (int id : map.keySet()) {
            pq.add(id);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
}