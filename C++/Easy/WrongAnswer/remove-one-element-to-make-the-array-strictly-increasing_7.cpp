class Solution {
public:
    bool canBeIncreasing(vector<int>& nums) {
        
        int n = nums.size();
        for (int i = 0; i < n; ++i) {
            vector<int> v(nums);
            v.erase(v.begin() + i);
            bool ok = true;
            for (int j = 1; j < n; ++j) {
                if (v[j] <= v[j - 1]) {
                    ok = false;
                    break;
                }
            }
            if (ok) return true;
        }
        return false;
    }
};