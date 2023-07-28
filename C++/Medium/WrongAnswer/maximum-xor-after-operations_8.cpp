class Solution {
public:
    int maximumXOR(vector<int>& nums) {
        
        int n = nums.size();
        int mask = 0;
        int max = 0;
        for (int i = 31; i >= 0; i--) {
            unordered_set<int> s;
            mask |= (1 << i);
            for (int num : nums) {
                s.insert(num & mask);
            }
            int newMax = max | (1 << i);
            for (int prefix : s) {
                if (s.find(prefix ^ newMax) != s.end()) {
                    max = newMax;
                    break;
                }
            }
        }
        return max;
    }
};