class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        
        int[] count = new int[2];
        for (int i = 0; i < students.length; i++) {
            count[students[i]]++;
        }
        int i = 0;
        while (i < sandwiches.length && count[sandwiches[i]] > 0) {
            count[sandwiches[i]]--;
            i++;
        }
        return sandwiches.length - i;
    }
}