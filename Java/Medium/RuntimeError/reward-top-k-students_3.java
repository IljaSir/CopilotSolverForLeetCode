class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        
        Map<String, Integer> positive = new HashMap<>();
        Map<String, Integer> negative = new HashMap<>();
        for (String s : positive_feedback) {
            positive.put(s, positive.getOrDefault(s, 0) + 1);
        }
        for (String s : negative_feedback) {
            negative.put(s, negative.getOrDefault(s, 0) + 1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < report.length; i++) {
            String s = report[i];
            int id = student_id[i];
            String[] words = s.split(" ");
            for (String word : words) {
                if (positive.containsKey(word)) {
                    map.put(id, map.getOrDefault(id, 0) + 3);
                }
                if (negative.containsKey(word)) {
                    map.put(id, map.getOrDefault(id, 0) - 1);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int id : map.keySet()) {
            ans.add(id);
        }
        ans.sort(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                if (map.get(a) != map.get(b)) {
                    return map.get(b) - map.get(a);
                } else {
                    return a - b;
                }
            }
        });
        return ans.subList(0, k);
    }
}