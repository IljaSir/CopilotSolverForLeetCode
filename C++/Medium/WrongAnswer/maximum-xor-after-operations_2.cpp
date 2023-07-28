class Solution {
public:
    int maximumXOR(vector<int>& nums) {
        
        int ans = 0;
        int mask = 0;
        for (int i = 31; i >= 0; --i) {
            mask |= 1 << i;
            unordered_set<int> s;
            for (int n : nums) {
                s.insert(n & mask);
            }
            int tmp = ans | (1 << i);
            for (int n : s) {
                if (s.find(n ^ tmp) != s.end()) {
                    ans = tmp;
                    break;
                }
            }
        }
        return ans;
    }
};