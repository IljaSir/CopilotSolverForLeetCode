class Solution {
    public int totalMoney(int n) {
        
        int sum = 0;
        int start = 1;
        int base = 1;
        for (int i = 0; i < n; i++) {
            if (i % 7 == 0 && i != 0) {
                start = base + 1;
                base = start;
            }
            sum += start;
            start++;
        }
        return sum;
    }
}