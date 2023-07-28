class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        
        int[] queue = new int[tickets.length];
        int time = 0;
        int index = 0;
        int max = 0;
        while(true){
            if(tickets[index] > 0){
                tickets[index]--;
                queue[index]++;
                max = Math.max(max, queue[index]);
                if(index == k && tickets[index] == 0){
                    break;
                }
            }
            index = (index + 1) % tickets.length;
            if(index == 0){
                time += max;
                max = 0;
            }
        }
        return time;
    }
}