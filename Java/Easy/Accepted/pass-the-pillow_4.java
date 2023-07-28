class Solution {
    public int passThePillow(int n, int time) {
        
        int[] people = new int[n];
        for (int i = 0; i < n; i++) {
            people[i] = i + 1;
        }
        int[] timeArr = new int[time];
        int count = 0;
        int index = 0;
        int direction = 1;
        while (count < time) {
            if (index == n - 1) {
                direction = -1;
            }
            if (index == 0) {
                direction = 1;
            }
            index += direction;
            timeArr[count] = people[index];
            count++;
        }
        return timeArr[time - 1];
    }
}