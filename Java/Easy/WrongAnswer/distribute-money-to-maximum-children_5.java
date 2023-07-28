class Solution {
    public int distMoney(int money, int children) {
        
        int max = 0, min = 0;
        while (money > 0) {
            if (money >= 8) {
                money -= 8;
                max++;
            } else {
                min++;
                money--;
            }
        }
        if (min == children) {
            return max;
        }
        return -1;
    }
}