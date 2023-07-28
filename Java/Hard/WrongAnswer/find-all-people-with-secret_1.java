class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < meetings.length; i++) {
            int x = meetings[i][0];
            int y = meetings[i][1];
            map.putIfAbsent(x, new ArrayList<>());
            map.get(x).add(y);
            map.putIfAbsent(y, new ArrayList<>());
            map.get(y).add(x);
        }
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(firstPerson);
        visited.add(firstPerson);
        while (!q.isEmpty()) {
            int cur = q.poll();
            res.add(cur);
            if (map.containsKey(cur)) {
                for (int next : map.get(cur)) {
                    if (!visited.contains(next)) {
                        q.offer(next);
                        visited.add(next);
                    }
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}