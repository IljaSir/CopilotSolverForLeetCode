class Solution {
public:
    vector<int> getNoZeroIntegers(int n) {
        
        vector<int> ans;
        for (int i = 1; i < n; i++) {
            if (isNoZero(i) && isNoZero(n - i)) {
                ans.push_back(i);
                ans.push_back(n - i);
                break;
            }
        }
        return ans;
    }
    
    bool isNoZero(int n) {
        while (n > 0) {
            if (n % 10 == 0) return false;
            n /= 10;
        }
        return true;
    }
};