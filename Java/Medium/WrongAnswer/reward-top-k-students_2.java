class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        Set<String> positive = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> negative = new HashSet<>(Arrays.asList(negative_feedback));
        for (int i = 0; i < report.length; i++) {
            String[] words = report[i].split(" ");
            for (String word : words) {
                if (positive.contains(word)) {
                    map.put(student_id[i], map.getOrDefault(student_id[i], 0) + 3);
                } else if (negative.contains(word)) {
                    map.put(student_id[i], map.getOrDefault(student_id[i], 0) - 1);
                }
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (map.get(b) == map.get(a)) {
                    return a - b;
                }
                return map.get(b) - map.get(a);
            }
        });
        for (int key : map.keySet()) {
            pq.offer(key);
        }
        List<Integer> res = new ArrayList<>();
        while (k > 0) {
            res.add(pq.poll());
            k--;
        }
        return res;
    }
}