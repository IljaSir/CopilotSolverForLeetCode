class Solution {
    public int totalMoney(int n) {
        
        int total = 0;
        int start = 1;
        int curr = 1;
        int day = 1;
        while (n > 0) {
            total += curr;
            curr++;
            day++;
            if (day > 7) {
                day = 1;
                curr = ++start;
            }
            n--;
        }
        return total;
    }
}