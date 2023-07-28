class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        int[][] result = new int[people.length][2];
        Arrays.sort(people, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : b[0] - a[0]);
        for (int[] person: people) {
            int spaces = person[1] + 1;
            for (int i = 0; i < people.length; i++) {
                if (result[i][0] == 0) {
                    spaces--;
                    if (spaces == 0) {
                        result[i] = person;
                        break;
                    }
                }
            }
        }
        return result;
    }
}