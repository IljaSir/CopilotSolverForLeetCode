class Solution {
    public int distMoney(int money, int children) {
        
        if (money < children) {
            return -1;
        }
        int x = money / children;
        if (x < 4) {
            return -1;
        }
        return Math.min(x - 3, children);
    }
}