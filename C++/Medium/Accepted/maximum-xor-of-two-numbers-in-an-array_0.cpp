class Solution {
public:
    int findMaximumXOR(vector<int>& nums) {
        
        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            unordered_set<int> set;
            for (int num : nums) {
                set.insert(num & mask);
            }
            int tmp = max | (1 << i);
            for (int prefix : set) {
                if (set.count(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
};