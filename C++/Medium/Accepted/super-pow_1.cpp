class Solution {
public:
    int superPow(int a, vector<int>& b) {
        
        if (b.empty()) return 1;
        int last_digit = b.back();
        b.pop_back();
        return powmod(superPow(a, b), 10) * powmod(a, last_digit) % 1337;
    }
    int powmod(int a, int k) {
        a %= 1337;
        int res = 1;
        for (int i = 0; i < k; i++) {
            res = res * a % 1337;
        }
        return res;
    }
};