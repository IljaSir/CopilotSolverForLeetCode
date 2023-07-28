class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(firstPerson);
        boolean[] visited = new boolean[n];
        visited[firstPerson] = true;
        while (!queue.isEmpty()) {
            int person = queue.poll();
            result.add(person);
            for (int[] meeting : meetings) {
                if (meeting[0] == person && !visited[meeting[1]]) {
                    queue.offer(meeting[1]);
                    visited[meeting[1]] = true;
                }
                if (meeting[1] == person && !visited[meeting[0]]) {
                    queue.offer(meeting[0]);
                    visited[meeting[0]] = true;
                }
            }
        }
        return result;
    }
}