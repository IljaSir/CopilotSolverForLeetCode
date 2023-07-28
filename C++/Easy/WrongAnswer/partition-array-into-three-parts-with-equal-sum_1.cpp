class Solution {
public:
    bool canThreePartsEqualSum(vector<int>& arr) {
        
        int sum = 0;
        for (int i = 0; i < arr.size(); ++i) {
            sum += arr[i];
        }
        if (sum % 3 != 0) {
            return false;
        }
        int target = sum / 3;
        int left = 0;
        int right = arr.size() - 1;
        int leftSum = 0;
        int rightSum = 0;
        while (left < right) {
            leftSum += arr[left];
            rightSum += arr[right];
            if (leftSum == target && rightSum == target) {
                return true;
            }
            if (leftSum != target) {
                ++left;
            }
            if (rightSum != target) {
                --right;
            }
        }
        return false;
    }
};