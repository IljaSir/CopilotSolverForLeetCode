class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        
        Map<String, Integer> positive = new HashMap<>();
        Map<String, Integer> negative = new HashMap<>();
        for (String str : positive_feedback) {
            positive.put(str, positive.getOrDefault(str, 0) + 1);
        }
        for (String str : negative_feedback) {
            negative.put(str, negative.getOrDefault(str, 0) + 1);
        }
        Map<Integer, Integer> students = new HashMap<>();
        for (int i = 0; i < report.length; i++) {
            String[] words = report[i].split(" ");
            for (String word : words) {
                if (positive.containsKey(word)) {
                    students.put(student_id[i], students.getOrDefault(student_id[i], 0) + 3);
                }
                if (negative.containsKey(word)) {
                    students.put(student_id[i], students.getOrDefault(student_id[i], 0) - 1);
                }
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> {
            if (a.getValue() == b.getValue()) {
                return a.getKey() - b.getKey();
            }
            return b.getValue() - a.getValue();
        });
        for (Map.Entry<Integer, Integer> entry : students.entrySet()) {
            pq.offer(entry);
        }
        List<Integer> ans = new ArrayList<>();
        while (k > 0) {
            ans.add(pq.poll().getKey());
            k--;
        }
        return ans;
    }
}