class Solution {
public:
    bool checkSubarraySum(vector<int>& nums, int k) {
        
        int n = nums.size();
        if (n < 2) return false;
        if (k == 0) {
            for (int i = 1; i < n; i++) {
                if (nums[i] == 0 && nums[i - 1] == 0) return true;
            }
            return false;
        }
        k = abs(k);
        vector<int> sums(n + 1);
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        unordered_set<int> st;
        for (int i = 2; i <= n; i++) {
            st.insert(sums[i - 2] % k);
            if (st.find(sums[i] % k) != st.end()) return true;
        }
        return false;
    }
};