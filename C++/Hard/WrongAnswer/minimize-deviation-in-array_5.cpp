class Solution {
public:
    int minimumDeviation(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> v(n);
        for (int i = 0; i < n; ++i) {
            if (nums[i] % 2 == 1) {
                v[i] = nums[i] * 2;
            } else {
                v[i] = nums[i];
            }
        }
        sort(v.begin(), v.end());
        int ans = v.back() - v.front();
        for (int i = 0; i < n; ++i) {
            while (v[i] % 2 == 0 && v[i] > v.front()) {
                v[i] /= 2;
                sort(v.begin(), v.end());
                ans = min(ans, v.back() - v.front());
            }
        }
        return ans;
    }
};