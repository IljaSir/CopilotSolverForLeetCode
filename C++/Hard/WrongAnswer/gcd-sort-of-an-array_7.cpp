class Solution {
public:
    bool gcdSort(vector<int>& nums) {
        
        int len = nums.size();
        vector<int> v = nums;
        sort(v.begin(), v.end());
        
        vector<int> idx(len);
        for(int i = 0; i < len; ++i) {
            idx[i] = i;
        }
        
        sort(idx.begin(), idx.end(), [&](int i, int j) {
            return gcd(nums[i], nums[j]) > 1;
        });
        
        for(int i = 0; i < len; ++i) {
            if(nums[idx[i]] != v[i]) {
                return false;
            }
        }
        return true;
    }
};