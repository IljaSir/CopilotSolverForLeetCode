class Solution {
    public int totalMoney(int n) {
        
        int sum = 0;
        int base = 1;
        int bonus = 0;
        for (int i = 1; i <= n; i++) {
            sum += base + bonus;
            base++;
            if (i % 7 == 0) {
                base = 1;
                bonus++;
            }
        }
        return sum;
    }
}