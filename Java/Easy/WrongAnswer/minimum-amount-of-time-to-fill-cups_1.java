class Solution {
    public int fillCups(int[] amount) {
        
        int[] cups = new int[3];
        int time = 0;
        while (cups[0] < amount[0] || cups[1] < amount[1] || cups[2] < amount[2]) {
            if (cups[0] < amount[0] && cups[1] < amount[1]) {
                cups[0]++;
                cups[1]++;
            } else if (cups[0] < amount[0] && cups[2] < amount[2]) {
                cups[0]++;
                cups[2]++;
            } else if (cups[1] < amount[1] && cups[2] < amount[2]) {
                cups[1]++;
                cups[2]++;
            } else if (cups[0] < amount[0]) {
                cups[0]++;
            } else if (cups[1] < amount[1]) {
                cups[1]++;
            } else if (cups[2] < amount[2]) {
                cups[2]++;
            }
            time++;
        }
        return time;
    }
}