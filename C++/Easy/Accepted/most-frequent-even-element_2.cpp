class Solution {
public:
    int mostFrequentEven(vector<int>& nums) {
        
        map<int, int> even;
        for (auto num : nums) {
            if (num % 2 == 0) {
                even[num]++;
            }
        }
        if (even.empty()) {
            return -1;
        }
        int max = 0;
        int min = 0;
        for (auto& e : even) {
            if (e.second > max) {
                max = e.second;
                min = e.first;
            } else if (e.second == max && e.first < min) {
                min = e.first;
            }
        }
        return min;
    }
};