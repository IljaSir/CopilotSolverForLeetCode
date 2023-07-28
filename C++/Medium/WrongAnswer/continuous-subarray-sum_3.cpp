class Solution {
public:
    bool checkSubarraySum(vector<int>& nums, int k) {
        
        int n = nums.size();
        if (k == 0) {
            for (int i = 0; i < n - 1; i++) {
                if (nums[i] == 0 && nums[i + 1] == 0) {
                    return true;
                }
            }
            return false;
        }
        vector<int> presum(n + 1);
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }
        unordered_set<int> st;
        for (int i = 0; i <= n; i++) {
            int x = presum[i] % k;
            if (st.count(x)) {
                return true;
            }
            st.insert(presum[i + 1] % k);
        }
        return false;
    }
};