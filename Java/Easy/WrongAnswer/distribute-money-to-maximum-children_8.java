class Solution {
    public int distMoney(int money, int children) {
        
        if(money < children * 2 || money > children * 30)
            return -1;
        int num = money / children;
        if(num == 4)
            return -1;
        if(num > 8)
            return children;
        return money - 8 * children;
    }
}