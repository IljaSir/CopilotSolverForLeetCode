class Solution {
public:
    int findMaximumXOR(vector<int>& nums) {
        
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            res <<= 1;
            unordered_set<int> s;
            for (int j = 0; j < nums.size(); j++) {
                s.insert(nums[j] >> i);
            }
            for (int j = 0; j < nums.size(); j++) {
                if (s.find(((res | 1) ^ (nums[j] >> i))) != s.end()) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
};