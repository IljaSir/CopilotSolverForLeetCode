class Solution {
public:
    int maximumXOR(vector<int>& nums) {
        
        int max = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= 1 << i;
            unordered_set<int> s;
            for (int n : nums) {
                s.insert(n & mask);
            }
            int tmp = max | (1 << i);
            for (int n : s) {
                if (s.find(n ^ tmp) != s.end()) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
};