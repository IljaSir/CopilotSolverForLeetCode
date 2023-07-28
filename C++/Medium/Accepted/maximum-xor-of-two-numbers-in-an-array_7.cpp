class Solution {
public:
    int findMaximumXOR(vector<int>& nums) {
        
        int mask = 0;
        int result = 0;
        for (int i = 30; i >= 0; i--) {
            mask |= (1 << i);
            unordered_set<int> set;
            for (auto num : nums) {
                set.insert(num & mask);
            }
            int newResult = result | (1 << i);
            for (auto prefix : set) {
                if (set.find(newResult ^ prefix) != set.end()) {
                    result = newResult;
                    break;
                }
            }
        }
        return result;
    }
};