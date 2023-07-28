class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        
        Set<String> posSet = new HashSet<String>();
        Set<String> negSet = new HashSet<String>();
        for (String s : positive_feedback) posSet.add(s);
        for (String s : negative_feedback) negSet.add(s);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < report.length; i++) {
            String[] words = report[i].split(" ");
            int id = student_id[i];
            for (String s : words) {
                if (posSet.contains(s)) map.put(id, map.getOrDefault(id, 0) + 3);
                else if (negSet.contains(s)) map.put(id, map.getOrDefault(id, 0) - 1);
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        for (int id : map.keySet()) {
            pq.add(new int[]{map.get(id), id});
            if (pq.size() > k) pq.poll();
        }
        while (!pq.isEmpty()) {
            ans.add(pq.poll()[1]);
        }
        Collections.reverse(ans);
        return ans;
    }
}