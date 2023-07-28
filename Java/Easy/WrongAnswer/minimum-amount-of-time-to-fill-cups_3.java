class Solution {
    public int fillCups(int[] amount) {
        
        int res = 0;
        int[] cups = new int[3];
        while (cups[0] < amount[0] || cups[1] < amount[1] || cups[2] < amount[2]) {
            res++;
            int[] next = new int[3];
            for (int i = 0; i < 3; i++) {
                next[i] = Math.min(cups[i] + 2, amount[i]);
            }
            if (next[0] == amount[0] && next[1] == amount[1] && next[2] == amount[2]) {
                return res;
            }
            if (next[0] == amount[0] && next[1] == amount[1]) {
                cups[2] = next[2];
                continue;
            }
            if (next[0] == amount[0] && next[2] == amount[2]) {
                cups[1] = next[1];
                continue;
            }
            if (next[1] == amount[1] && next[2] == amount[2]) {
                cups[0] = next[0];
                continue;
            }
            if (next[0] == amount[0]) {
                cups[1] = next[1];
                cups[2] = next[2];
                continue;
            }
            if (next[1] == amount[1]) {
                cups[0] = next[0];
                cups[2] = next[2];
                continue;
            }
            if (next[2] == amount[2]) {
                cups[0] = next[0];
                cups[1] = next[1];
                continue;
            }
            cups[0] = next[0];
            cups[1] = next[1];
            cups[2] = next[2];
        }
        return res;
    }
}