class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        
        int count = 0;
        int max = 0;
        int[] arr = new int[tickets.length];
        for (int i = 0; i < tickets.length; i++) {
            max = Math.max(max, tickets[i]);
        }
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < tickets.length; j++) {
                if (tickets[j] > 0) {
                    tickets[j]--;
                    arr[j]++;
                }
            }
        }
        for (int i = 0; i < k; i++) {
            count += arr[i];
        }
        return count;
    }
}