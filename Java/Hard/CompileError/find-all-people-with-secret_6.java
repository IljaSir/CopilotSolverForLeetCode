class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        
        List<Integer> result = new ArrayList<>();
        result.add(firstPerson);
        Set<Integer> set = new HashSet<>();
        set.add(firstPerson);
        for (int i = 0; i < meetings.length; i++) {
            if (set.contains(meetings[i][0])) {
                result.add(meetings[i][1]);
                set.add(meetings[i][1]);
            }
            if (set.contains(meetings[i][1])) {
                result.add(meetings[i][0]);
                set.add(meetings[i][0]);
            }
        }
        return result;
    }
}
    }
}