class Solution {
public:
    bool canThreePartsEqualSum(vector<int>& arr) {
        
        int sum = 0;
        for (int a : arr) sum += a;
        if (sum % 3 != 0) return false;
        int target = sum / 3;
        int count = 0;
        int cur = 0;
        for (int a : arr) {
            cur += a;
            if (cur == target) {
                cur = 0;
                count++;
            }
        }
        return count >= 3;
    }
};