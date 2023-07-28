class Solution {
public:
    int subarraysDivByK(vector<int>& nums, int k) {
        
        int sum = 0;
        unordered_map<int, int> m;
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            int mod = (sum % k + k) % k;
            count += m[mod];
            m[mod]++;
            if (sum % k == 0) {
                count++;
            }
        }
        return count;
    }
};