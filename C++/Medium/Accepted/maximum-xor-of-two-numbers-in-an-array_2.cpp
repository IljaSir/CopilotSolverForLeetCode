class Solution {
public:
    int findMaximumXOR(vector<int>& nums) {
        
        int mask = 0, max = 0;
        for (int i = 31; i >= 0; --i) {
            mask |= (1 << i);
            unordered_set<int> set;
            for (int num : nums) {
                set.insert(num & mask);
            }
            int tmp = max | (1 << i);
            for (int prefix : set) {
                if (set.find(tmp ^ prefix) != set.end()) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
};