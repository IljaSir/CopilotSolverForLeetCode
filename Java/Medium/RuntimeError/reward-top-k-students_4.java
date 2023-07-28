class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        
        Map<Integer, Integer> score = new HashMap<>();
        Set<String> pos = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> neg = new HashSet<>(Arrays.asList(negative_feedback));
        for (int i = 0; i < report.length; i++) {
            int id = student_id[i];
            String[] words = report[i].split(" ");
            for (String word : words) {
                if (pos.contains(word)) {
                    score.put(id, score.getOrDefault(id, 0) + 3);
                } else if (neg.contains(word)) {
                    score.put(id, score.getOrDefault(id, 0) - 1);
                }
            }
        }
        List<Integer> ans = new ArrayList<>(score.keySet());
        ans.sort((a, b) -> {
            int cmp = Integer.compare(score.get(b), score.get(a));
            if (cmp != 0) {
                return cmp;
            }
            return Integer.compare(a, b);
        });
        return ans.subList(0, k);
    }
}