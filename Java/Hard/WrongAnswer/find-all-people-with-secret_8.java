class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[n];
        visited[firstPerson] = true;
        result.add(firstPerson);
        for (int[] meeting : meetings) {
            if (visited[meeting[0]] && !visited[meeting[1]]) {
                result.add(meeting[1]);
                visited[meeting[1]] = true;
            } else if (visited[meeting[1]] && !visited[meeting[0]]) {
                result.add(meeting[0]);
                visited[meeting[0]] = true;
            }
        }
        return result;
    }
}