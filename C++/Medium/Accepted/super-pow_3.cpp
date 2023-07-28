class Solution {
public:
    int superPow(int a, vector<int>& b) {
        
        int n = b.size();
        if (n == 0) return 1;
        int last = b[n - 1];
        b.pop_back();
        return powmod(superPow(a, b), 10) * powmod(a, last) % 1337;
    }
    int powmod(int a, int k) {
        a %= 1337;
        int res = 1;
        for (int i = 0; i < k; i++) {
            res *= a;
            res %= 1337;
        }
        return res;
    }
};