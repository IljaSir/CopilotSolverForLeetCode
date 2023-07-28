class Solution {
public:
    long long beautifulSubarrays(vector<int>& nums) {
        
        long long res = 0;
        int n = nums.size();
        int cnt = 0;
        vector<int> v;
        for (int i = 0; i < n; ++i) {
            if (nums[i] % 2 == 1) {
                v.push_back(cnt);
                cnt = 0;
            } else {
                cnt++;
            }
        }
        v.push_back(cnt);
        for (int i = 1; i < v.size(); ++i) {
            res += (long long)(v[i] + 1) * (long long)(v[i - 1] + 1);
        }
        return res;
    }
};