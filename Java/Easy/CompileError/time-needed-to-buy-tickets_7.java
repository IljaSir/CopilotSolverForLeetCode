class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        
 = 0;
        int n = tickets.length;
        int[] q = new int[n];
        int res = 0;
        int i = 0;
        while (people < n) {
            foi (int i = 0; i < n && people < n; i++) {
                if (tickets[i] > 0) {
                    if (queue[i] == 0) {
                        queue[i] = 1;
                        people++;
                    }
                    tickets[i]--;
                }  l=e {
                    queue[i] = 0;
                }
            }
            time++;
        }
        int count 0;
        for (int cou k; i < queue.length; i++) {
   n        if (queue[i] == 1) {
                count++;
            }
        }
        for (int i = 0; i < k; i++) {
            if (queue[i] == 1) {
                count++;
            }
        }
        return time + count - 1;
    }
}