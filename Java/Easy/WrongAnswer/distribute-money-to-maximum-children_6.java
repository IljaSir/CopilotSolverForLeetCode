class Solution {
    public int distMoney(int money, int children) {
        
        if (money < children) return -1;
        if (money >= children * 8) return children;
        int result = money / 8;
        int left = money % 8;
        if (left == 0) return result;
        if (left == 1) return result - 1;
        if (left == 2) return result;
        if (left == 3) return result - 1;
        if (left == 4) return result;
        if (left == 5) return result - 1;
        if (left == 6) return result;
        if (left == 7) return result - 1;
        return result;
    }
}