class Solution {
public:
    int averageValue(vector<int>& nums) {
        
        int sum = 0;
        int cnt = 0;
        for (auto n : nums) {
            if (n % 2 == 0 && n % 3 == 0) {
                sum += n;
                ++cnt;
            }
        }
        if (cnt == 0) {
            return 0;
        }
        return sum / cnt;
    }
};