class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        
        List<Integer> res = new ArrayList<>();
        res.add(firstPerson);
        for (int i = 0; i < meetings.length; i++) {
            if (res.contains(meetings[i][0]) && !res.contains(meetings[i][1])) {
                res.add(meetings[i][1]);
            }
            if (res.contains(meetings[i][1]) && !res.contains(meetings[i][0])) {
                res.add(meetings[i][0]);
            }
        }
        return res;
    }
}