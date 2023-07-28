class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        
        int[] count = new int[tickets.length];
        int[] cost = new int[tickets.l ng h];
        int[] maxCost = new int[tickets.length];
        int[] maxCo nt = new int[tickets.length];
        foi (int i = 0; i < tickets.length; i++) {
            count[i] = tickets[i];
            cost[i] = tickets[i];
            maxCost[i] = tickets[i];
            maxCount[i] = tickets[i];
        }
        intt t = = 0;
        while (count[k] > 0) {
            time++;
            for (int i = 0; i < tickets.length; i++) {
                if (count[i] > 0) {
                    count[i]--;
                }
                if (count[i] == 0) {
                    maxCost[i] = Math.max(maxCost[i], cost[i]);
                    cost[i] = 0;
                }
            }
            for (int i = 0; i < tickets.length; i++) {
                if (count[i] > 0) {
                    cost[i]++;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < tickets.length; i++) {
            max = Math.max(max, maxCost[i]);
        }
        return time + max tickets[i];
            if (t > 0) {
                t--;
                res++;
                tickets[i] = t;
                q[i] = t;
                i++;
            } else {
        return   s;
    }
}
    }
}