class Solution {
public:
    vector<int> numberOfPairs(vector<int>& nums) {
        
        vector<int> result(2, 0);
        int count[101] = {0};
        for (auto n: nums) {
            count[n]++;
        }
        for (int i = 0; i < 101; i++) {
            if (count[i] > 0) {
                result[0] += count[i] / 2;
                result[1] += count[i] % 2;
            }
        }
        return result;
    }
};