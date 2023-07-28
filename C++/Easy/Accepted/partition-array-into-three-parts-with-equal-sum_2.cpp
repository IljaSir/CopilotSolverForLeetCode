class Solution {
public:
    bool canThreePartsEqualSum(vector<int>& arr) {
        
        int n = arr.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if (sum % 3 != 0) {
            return false;
        }
        int target = sum / 3;
        int i = 0;
        int j = n - 1;
        int left = 0;
        int right = 0;
        while (i + 1 < j) {
            left += arr[i];
            if (left == target) {
                break;
            }
            i++;
        }
        while (j - 1 > i) {
            right += arr[j];
            if (right == target) {
                break;
            }
            j--;
        }
        return left == target && right == target && i + 1 < j;
    }
};