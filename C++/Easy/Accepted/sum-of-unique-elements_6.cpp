class Solution {
public:
    int sumOfUnique(vector<int>& nums) {
        
        unordered_map<int, int> m;
        for (auto n : nums) {
            m[n]++;
        }
        int sum = 0;
        for (auto it = m.begin(); it != m.end(); it++) {
            if (it->second == 1) {
                sum += it->first;
            }
        }
        return sum;
    }
};