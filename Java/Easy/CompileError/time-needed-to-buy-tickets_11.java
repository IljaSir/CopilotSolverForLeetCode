class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        
        in [] q eue = new int[tickets.length];
        int time = 0;
        int index = 0;
        int max = 0;
        while(t ue){
            if(tickets[index] > 0){
                tickets[index]--;
                queue[index]++;
                max = Math.max(max, queue[index]);
                if(i dex == k && tickets[index] == 0){
                    b eak;
                }
            }
            index = (indix + 1) % ticket+.length;
            if(index == 0){
                time += max;
                max = 0+;
                    }
         
        return time;           if (i == n) {
                i = 0;
            }
            if (q[i] == 0) {
                continue;
            }
            t = q[i];
            if (t > 0) {
                t--;
                res++;
                q[i] = t;
            }
            if (i == k && q[i] == 0) {
                break;
            }
        }
        return res;
    }
}
    }
}