class Solution {
public:
    int mostFrequentEven(vector<int>& nums) {
        
        unordered_map<int, int> count;
        for (auto n : nums) {
            if (n % 2 == 0) {
                count[n]++;
            }
        }
        int maxCount = 0;
        int result = -1;
        for (auto& [n, c] : count) {
            if (c > maxCount) {
                maxCount = c;
                result = n;
            }
        }
        return result;
    }
};