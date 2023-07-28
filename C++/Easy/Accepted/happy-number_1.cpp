class Solution {
public:
    bool isHappy(int n) {
        
        unordered_set<int> s;
        while (n != 1 && s.find(n) == s.end()) {
            s.insert(n);
            int m = 0;
            while (n > 0) {
                m += (n % 10) * (n % 10);
                n /= 10;
            }
            n = m;
        }
        return n == 1;
    }
};