class Solution {
public:
    int maximumXOR(vector<int>& nums) {
        
        int n = nums.size();
        int max = 0;
        int mask = 0;
        for(int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            set<int> s;
            for(int num: nums) {
                s.insert(mask & num);
            }
            int tmp = max | (1 << i);
            for(int prefix: s) {
                if(s.find(prefix ^ tmp) != s.end()) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
};