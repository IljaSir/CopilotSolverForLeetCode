class Solution {
    public int distMoney(int money, int children) {
        
        if (money < 2 * children + 1) return -1;
        return Math.min(children, (money - 1) / 2 - children);
    }
}