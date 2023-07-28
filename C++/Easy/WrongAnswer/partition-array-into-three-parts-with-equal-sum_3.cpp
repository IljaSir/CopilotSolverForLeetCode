class Solution {
public:
    bool canThreePartsEqualSum(vector<int>& arr) {
        
        int sum = 0;
        for (auto i : arr) {
            sum += i;
        }
        if (sum % 3 != 0) {
            return false;
        }
        sum /= 3;
        int cur = 0;
        int count = 0;
        for (auto i : arr) {
            cur += i;
            if (cur == sum) {
                cur = 0;
                count++;
            }
        }
        return count == 3;
    }
};