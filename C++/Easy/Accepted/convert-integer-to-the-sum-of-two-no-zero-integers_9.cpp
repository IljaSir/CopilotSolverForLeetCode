class Solution {
public:
    vector<int> getNoZeroIntegers(int n) {
        
        vector<int> ret;
        for(int i = 1; i < n; i++) {
            if (!check(i) && !check(n - i)) {
                ret.push_back(i);
                ret.push_back(n - i);
                break;
            }
        }
        return ret;
    }
    bool check(int n) {
        while(n) {
            if (n % 10 == 0) return true;
            n /= 10;
        }
        return false;
    }
};