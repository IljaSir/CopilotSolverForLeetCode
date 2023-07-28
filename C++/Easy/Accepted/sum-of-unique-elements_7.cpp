class Solution {
public:
    int sumOfUnique(vector<int>& nums) {
        
        int sum = 0;
        map<int, int> count;
        for (auto i : nums) {
            count[i]++;
        }
        for (auto i : count) {
            if (i.second == 1) {
                sum += i.first;
            }
        }
        return sum;
    }
};