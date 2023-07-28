class Solution {
public:
    int sumOfUnique(vector<int>& nums) {
        
        int sum = 0;
        unordered_map<int, int> map;
        for (int i = 0; i < nums.size(); i++) {
            map[nums[i]]++;
        }
        for (auto it = map.begin(); it != map.end(); it++) {
            if (it->second == 1) {
                sum += it->first;
            }
        }
        return sum;
    }
};