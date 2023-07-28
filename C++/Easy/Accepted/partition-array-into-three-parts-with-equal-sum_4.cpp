class Solution {
public:
    bool canThreePartsEqualSum(vector<int>& arr) {
        
        int sum = 0;
        for (int x : arr) {
            sum += x;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int target = sum / 3;
        int cur = 0;
        int count = 0;
        for (int x : arr) {
            cur += x;
            if (cur == target) {
                cur = 0;
                count++;
            }
        }
        return count >= 3;
    }
};