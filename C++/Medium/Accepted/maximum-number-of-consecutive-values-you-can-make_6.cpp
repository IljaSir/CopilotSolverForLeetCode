class Solution {
public:
    int getMaximumConsecutive(vector<int>& coins) {
        
        sort(coins.begin(), coins.end());
        int sum = 0;
        for (auto c : coins) {
            if (c > sum + 1) {
                break;
            }
            sum += c;
        }
        return sum + 1;
    }
};