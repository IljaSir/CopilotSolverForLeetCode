class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        
        List<Integer> ans = new ArrayList<>();
        ans.add(firstPerson);
        for (int[] meeting : meetings) {
            if (ans.contains(meeting[0])) {
                ans.add(meeting[1]);
            }
            if (ans.contains(meeting[1])) {
                ans.add(meeting[0]);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}