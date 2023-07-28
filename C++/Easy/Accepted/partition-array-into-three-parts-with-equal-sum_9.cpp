class Solution {
public:
    bool canThreePartsEqualSum(vector<int>& arr) {
        
        int sum = 0;
        for (auto &x: arr) sum += x;
        if (sum % 3 != 0) return false;
        int target = sum / 3;
        int cur = 0;
        int cnt = 0;
        for (auto &x: arr) {
            cur += x;
            if (cur == target) {
                ++cnt;
                cur = 0;
            }
        }
        return cnt >= 3;
    }
};