class Solution {
    public int distMoney(int money, int children) {
        
        if (children * 8 > money) {
            return -1;
        }
        if (money - children * 8 == 0) {
            return children;
        }
        return 1 + (money - children * 8) / (children * 2);
    }
}