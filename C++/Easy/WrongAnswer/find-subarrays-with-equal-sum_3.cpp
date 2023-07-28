class Solution {
public:
    bool findSubarrays(vector<int>& nums) {
        
        int n = nums.size();
        unordered_set<int> s;
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += nums[i];
            if (s.find(sum) != s.end()) {
                return true;
            }
            s.insert(sum);
        }
        return false;
    }
};