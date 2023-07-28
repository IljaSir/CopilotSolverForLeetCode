class Solution {
public:
    int fillCups(vector<int>& amount) {
        
        int max = 0;
        for (int i = 0; i < amount.size(); i++) {
            if (max < amount[i]) {
                max = amount[i];
            }
        }
        int sum = 0;
        for (int i = 0; i < amount.size(); i++) {
            sum += amount[i];
        }
        return max + (sum - max) / 2;
    }
};