class Solution {
public:
    int superPow(int a, vector<int>& b) {
        
        int len = b.size();
        if (len == 0) return 1;
        int last = b[len - 1];
        b.pop_back();
        int part1 = pow(a, last);
        int part2 = pow(superPow(a, b), 10);
        return (part1 * part2) % 1337;
    }
    
    int pow(int a, int k) {
        a %= 1337;
        int res = 1;
        for (int i = 0; i < k; i++) {
            res *= a;
            res %= 1337;
        }
        return res;
    }
};