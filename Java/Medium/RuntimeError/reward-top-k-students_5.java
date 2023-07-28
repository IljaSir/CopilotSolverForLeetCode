class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Set<String> positive = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> negative = new HashSet<>(Arrays.asList(negative_feedback));
        for (int i = 0; i < report.length; i++) {
            String[] feedback = report[i].split(" ");
            for (String word : feedback) {
                if (positive.contains(word)) {
                    map.put(student_id[i], map.getOrDefault(student_id[i], 0) + 3);
                } else if (negative.contains(word)) {
                    map.put(student_id[i], map.getOrDefault(student_id[i], 0) - 1);
                }
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new int[] {entry.getValue(), entry.getKey()});
        }
        while (k > 0) {
            result.add(pq.poll()[1]);
            k--;
        }
        return result;
    }
}