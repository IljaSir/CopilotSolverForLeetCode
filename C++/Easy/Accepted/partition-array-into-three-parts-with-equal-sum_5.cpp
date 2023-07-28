class Solution {
public:
    bool canThreePartsEqualSum(vector<int>& arr) {
        
        int sum = accumulate(arr.begin(), arr.end(), 0);
        if (sum % 3 != 0) return false;
        int target = sum / 3;
        int count = 0;
        sum = 0;
        for (auto n : arr) {
            sum += n;
            if (sum == target) {
                sum = 0;
                count++;
            }
        }
        return count >= 3;
    }
};