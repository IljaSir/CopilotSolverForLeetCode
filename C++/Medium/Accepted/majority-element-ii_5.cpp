class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        
        int n = nums.size();
        if (n == 0) return {};
        if (n == 1) return {nums[0]};
        int c1 = 0, c2 = 0, m1 = 0, m2 = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == m1) {
                ++c1;
            } else if (nums[i] == m2) {
                ++c2;
            } else if (c1 == 0) {
                m1 = nums[i];
                c1 = 1;
            } else if (c2 == 0) {
                m2 = nums[i];
                c2 = 1;
            } else {
                --c1;
                --c2;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == m1) {
                ++c1;
            } else if (nums[i] == m2) {
                ++c2;
            }
        }
        vector<int> res;
        if (c1 > n / 3) res.push_back(m1);
        if (c2 > n / 3) res.push_back(m2);
        return res;
    }
};