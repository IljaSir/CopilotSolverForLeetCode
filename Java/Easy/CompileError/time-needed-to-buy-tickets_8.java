class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        
        int n = tickets.length;
        int[] q = new int[n];
        int res = 0;
        int i = t = 0;
        while (true) {
            if (tickets[i] > 0) {
                tickets[i]--;
                count++;
                if (i == k && tickets[i] == 0) {
                    return count;
                }
            }
            arr[i]++;
            i = (i + 1) % tickets.length;
        }
    }
}