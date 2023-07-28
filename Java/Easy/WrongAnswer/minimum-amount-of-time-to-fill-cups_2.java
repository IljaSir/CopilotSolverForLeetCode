class Solution {
    public int fillCups(int[] amount) {
        
        int ans = 0;
        int[] cups = new int[3];
        while (cups[0] < amount[0] || cups[1] < amount[1] || cups[2] < amount[2]) {
            if (cups[0] < amount[0] && cups[1] < amount[1]) {
                cups[0]++;
                cups[1]++;
                ans++;
            }
            if (cups[1] < amount[1] && cups[2] < amount[2]) {
                cups[1]++;
                cups[2]++;
                ans++;
            }
            if (cups[0] < amount[0] && cups[2] < amount[2]) {
                cups[0]++;
                cups[2]++;
                ans++;
            }
            if (cups[0] < amount[0]) {
                cups[0]++;
                ans++;
            }
            if (cups[1] < amount[1]) {
                cups[1]++;
                ans++;
            }
            if (cups[2] < amount[2]) {
                cups[2]++;
                ans++;
            }
        }
        return ans;
    }
}