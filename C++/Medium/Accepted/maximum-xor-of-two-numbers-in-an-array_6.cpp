class Solution {
public:
    int findMaximumXOR(vector<int>& nums) {
        
        int mask = 0, max = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= 1 << i;
            set<int> prefix;
            for (int num : nums) {
                prefix.insert(num & mask);
            }
            int tmp = max | (1 << i);
            for (int p : prefix) {
                if (prefix.find(tmp ^ p) != prefix.end()) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
};