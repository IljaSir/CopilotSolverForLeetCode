class Solution {
public:
    int superPow(int a, vector<int>& b) {
        
        if (b.empty()) return 1;
        int last = b.back();
        b.pop_back();
        return powMod(superPow(a, b), 10) * powMod(a, last) % 1337;
    }
};