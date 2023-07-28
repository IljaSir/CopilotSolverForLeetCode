class Solution {
    public int distMoney(int money, int children) {
        
        if (money < children + 4) {
            return -1;
        }
        int res = 0;
        int max = money - children;
        if (max % 8 == 0) {
            res = max / 8;
        } else {
            res = max / 8 + 1;
        }
        return res;
    }
}