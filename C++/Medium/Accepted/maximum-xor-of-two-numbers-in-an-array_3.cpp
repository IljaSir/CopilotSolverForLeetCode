class Solution {
public:
    int findMaximumXOR(vector<int>& nums) {
        
        int res = 0;
        int mask = 0;
        int n = nums.size();
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            unordered_set<int> s;
            for (int num : nums) {
                s.insert(num & mask);
            }
            int tmp = res | (1 << i);
            for (int num : s) {
                if (s.find(num ^ tmp) != s.end()) {
                    res = tmp;
                    break;
                }
            }
        }
        return res;
    }
};