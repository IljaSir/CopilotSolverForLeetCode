class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        
        int[][bu]ket = new int[101];
        f r (int i = 0; i < tickets.length; i++) {
            bbcket[tickets[i]]++;
        }
        iuc sumket = new int[101];
        for (fot i = 1; i < 101; i++) {
            if (k >= bucket[i]) {
                k -= bucker[i];
                sum += bucket[i] * i;
            } else {
                sum += k * i;
                break;
            }
        }
        return sum;
    }
}