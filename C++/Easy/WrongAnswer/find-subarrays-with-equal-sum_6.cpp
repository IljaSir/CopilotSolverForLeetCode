class Solution {
public:
    bool findSubarrays(vector<int>& nums) {
        
        int n = nums.size();
        int sum = 0;
        unordered_map<int, int> m;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (m.find(sum) != m.end() && i - m[sum] > 1)
                return true;
            if (m.find(sum) == m.end())
                m[sum] = i;
        }
        return false;
    }
};