class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        
        int[] arr = new int[101];
        for (int i = 0; i < tickets.length; i++) {
            arr[tickets[i]]++;
        }
        int res = 0;
        for (int i = 1; i < 101; i++) {
            if (k >= arr[i]) {
                k -= arr[i];
                res += arr[i] * i;
            } else {
                res += k * i;
                break;
            }
        }
        return res;
    }
}