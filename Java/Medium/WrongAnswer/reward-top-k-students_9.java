class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        
        Map<String, Integer> positive = new HashMap<>();
        Map<String, Integer> negative = new HashMap<>();
        Map<Integer, Integer> points = new HashMap<>();
        for (String s : positive_feedback) {
            positive.put(s, 1);
        }
        for (String s : negative_feedback) {
            negative.put(s, 1);
        }
        for (int i = 0; i < report.length; i++) {
            String[] words = report[i].split(" ");
            for (String word : words) {
                if (positive.containsKey(word)) {
                    points.put(student_id[i], points.getOrDefault(student_id[i], 0) + 3);
                }
                if (negative.containsKey(word)) {
                    points.put(student_id[i], points.getOrDefault(student_id[i], 0) - 1);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> points.get(a) == points.get(b) ? b - a : points.get(a) - points.get(b));
        for (int id : points.keySet()) {
            pq.offer(id);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        Collections.reverse(result);
        return result;
    }
}