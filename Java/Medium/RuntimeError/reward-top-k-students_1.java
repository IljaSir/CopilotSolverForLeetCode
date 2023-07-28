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
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) == map.get(a) ? a - b : map.get(b) - map.get(a));
        return list.subList(0, k);
    }
}