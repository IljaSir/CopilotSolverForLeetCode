class Solution {
public:
    int findLengthOfShortestSubarray(vector<int>& arr) {
        
        int left = 0;
        int right = arr.size() - 1;
        while (left < right && arr[left] <= arr[left + 1]) {
            left++;
        }
        if (left == right) {
            return 0;
        }
        while (right > left && arr[right - 1] <= arr[right]) {
            right--;
        }
        int result = min(arr.size() - left - 1, right);
        int i = 0;
        int j = right;
        while (i <= left && j < arr.size()) {
            if (arr[i] <= arr[j]) {
                result = min(result, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        return result;
    }
};