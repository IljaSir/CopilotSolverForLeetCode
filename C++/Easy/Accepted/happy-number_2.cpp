class Solution {
public:
    bool isHappy(int n) {
        
        unordered_set<int> s;
        while (n != 1) {
            if (s.count(n)) return false;
            s.insert(n);
            int m = 0;
            while (n) {
                m += (n % 10) * (n % 10);
                n /= 10;
            }
            n = m;
        }
        return true;
    }
};