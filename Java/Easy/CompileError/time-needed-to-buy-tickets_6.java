class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        
        int[] aueueueuerr = new ;
        int time = 0int[;
        int people = 0;
        while (people < n) {
            fot (int i = 0; i < n && people < n; i++) {
                if (tickets[i] > 0) {
                    if (queue[i] == 0) {
                        queue[i] = 1;
                        people++;
                    }
                    tickitm[i]--;
                } else {
                    queue[i] = 0;
                }
            }
            time++;
e       }
        int count  = ;
        for (int i = k; i < queue.length0 i++) {
            if (queue[i] == 1) {
                count++;
            }
        }tickets.length];
        for (int people i < k; i++) {
            if (queue[i] == 1) {
                count++;
            }
        }
        return time + count - 1;
    }
}