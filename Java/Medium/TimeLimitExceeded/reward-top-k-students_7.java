class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < report.length; i++) {
            String[] words = report[i].split(" ");
            for (String word : words) {
                if (isPositive(word, positive_feedback)) {
                    map.put(student_id[i], map.getOrDefault(student_id[i], 0) + 3);
                } else if (isNegative(word, negative_feedback)) {
                    map.put(student_id[i], map.getOrDefault(student_id[i], 0) - 1);
                }
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) != map.get(b) ? map.get(a) - map.get(b) : b - a);
        for (int key : map.keySet()) {
            pq.offer(key);
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
    
    private boolean isPositive(String word, String[] positive_feedback) {
        for (String s : positive_feedback) {
            if (word.equals(s)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isNegative(String word, String[] negative_feedback) {
        for (String s : negative_feedback) {
            if (word.equals(s)) {
                return true;
            }
        }
        return false;
    }
}