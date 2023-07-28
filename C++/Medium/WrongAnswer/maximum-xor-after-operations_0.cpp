class Solution {
public:
    int maximumXOR(vector<int>& nums) {
        
        int ans = 0;
        int mask = 0;
        for (int i = 30; i >= 0; i--) {
            mask |= (1 << i);
            unordered_set<int> s;
            for (int num : nums) {
                s.insert(num & mask);
            }
            int tmp = ans | (1 << i);
            for (int prefix : s) {
                if (s.find(prefix ^ tmp) != s.end()) {
                    ans = tmp;
                    break;
                }
            }
        }
        return ans;
    }
};