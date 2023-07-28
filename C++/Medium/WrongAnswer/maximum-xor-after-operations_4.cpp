class Solution {
public:
    int maximumXOR(vector<int>& nums) {
        
        int max = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i--) {
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