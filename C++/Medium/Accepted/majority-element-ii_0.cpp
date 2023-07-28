class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        
        int n = nums.size();
        int a = 0, b = 0, ca = 0, cb = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == a) {
                ++ca;
            } else if (nums[i] == b) {
                ++cb;
            } else if (ca == 0) {
                a = nums[i];
                ++ca;
            } else if (cb == 0) {
                b = nums[i];
                ++cb;
            } else {
                --ca;
                --cb;
            }
        }
        ca = 0;
        cb = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == a) {
                ++ca;
            } else if (nums[i] == b) {
                ++cb;
            }
        }
        vector<int> res;
        if (ca > n / 3) {
            res.push_back(a);
        }
        if (cb > n / 3) {
            res.push_back(b);
        }
        return res;
    }
};