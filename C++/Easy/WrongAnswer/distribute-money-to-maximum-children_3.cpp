class Solution {
public:
    int distMoney(int money, int children) {
        
        int ans = 0;
        int each = money / children;
        if (each < 8) return -1;
        for (int i = 0; i < children; i++) {
            if (each - i == 8) {
                ans++;
            }
        }
        return ans;
    }
};