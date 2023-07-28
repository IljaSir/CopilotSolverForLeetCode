class Solution {
public:
    int maximumXOR(vector<int>& nums) {
        
        int res = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            unordered_set<int> s;
            for (int num : nums) {
                s.insert(mask & num);
            }
            int tmp = res | (1 << i);
            for (int prefix : s) {
                if (s.find(tmp ^ prefix) != s.end()) {
                    res = tmp;
                    break;
                }
            }
        }
        return res;
    }
};