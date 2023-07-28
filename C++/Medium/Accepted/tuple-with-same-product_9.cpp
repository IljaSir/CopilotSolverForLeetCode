class Solution {
public:
    int tupleSameProduct(vector<int>& nums) {
        
        unordered_map<int, int> map;
        int count = 0;
        int n = nums.size();
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int product = nums[i] * nums[j];
                if (map.find(product) != map.end()) {
                    count += map[product] * 8;
                }
                ++map[product];
            }
        }
        return count;
    }
};