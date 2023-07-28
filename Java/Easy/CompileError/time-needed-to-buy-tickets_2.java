class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        
        int count = 0;
        int (int i = 0; i < tickets.length; i++) {
            bucket[tickets[i]]++;
        }
        int sum = 0;
        for (int i = 1; i < 101; i++) {
            if (k >= bucket[i]) {
                k -= bucket[i];
                sum += bucket[i] * i;
            } else {
                sum += k * i;
                break;
            }
        }
        return sum;
    }
}