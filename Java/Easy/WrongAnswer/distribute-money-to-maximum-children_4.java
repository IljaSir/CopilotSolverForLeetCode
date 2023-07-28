class Solution {
    public int distMoney(int money, int children) {
        
        int ans = 0;
        while (money > 0) {
            ans = Math.min(children, money / 8);
            money -= ans * 8;
            children -= ans;
            if (money >= 4) {
                money -= 4;
                children--;
            } else {
                break;
            }
        }
        return money == 0 && children == 0 ? ans : -1;
    }
}