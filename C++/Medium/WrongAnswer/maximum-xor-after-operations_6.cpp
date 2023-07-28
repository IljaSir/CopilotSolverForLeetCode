class Solution {
public:
    int maximumXOR(vector<int>& nums) {
        
        int n = nums.size();
        int mask = 0;
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            unordered_set<int> s;
            for (int num: nums) {
                s.insert(num & mask);
            }
            int tmp = ans | (1 << i);
            for (int num: s) {
                if (s.count(num ^ tmp)) {
                    ans = tmp;
                    break;
                }
            }
        }
        return ans;
    }
};