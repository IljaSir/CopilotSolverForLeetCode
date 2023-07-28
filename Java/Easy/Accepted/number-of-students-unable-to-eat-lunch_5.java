class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        
        int count = 0;
        int[] countStudents = new int[2];
        for (int i = 0; i < students.length; i++) {
            countStudents[students[i]]++;
        }
        for (int i = 0; i < sandwiches.length; i++) {
            int index = sandwiches[i];
            if (countStudents[index] == 0) {
                return sandwiches.length - i;
            }
            countStudents[index]--;
        }
        return 0;
    }
}