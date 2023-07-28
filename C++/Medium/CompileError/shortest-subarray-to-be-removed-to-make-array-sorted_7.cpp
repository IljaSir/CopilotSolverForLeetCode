class Solution {
public:
    int findLengthOfShortestSubarray(vector<int>& arr) {
        
        // Find the first index from the left that is not sorted
        // Find the first index from the right that is not sorted
        // Find the first index from the left that is greater than the right index
        // Find the first index from the right that is less than the left index
        // Return the min of the difference between the indices
        int left = 0;
        int right = arr.size() - 1;
        while(left < arr.size() - 1 && arr[left] <= arr[left + 1]) left++;
        if(left == arr.size() - 1) return 0;
        while(right > 0 && arr[right] >= arr[right - 1]) right--;
        int result = min(arr.size() - left - 1, right);
        int i = 0;
        int j = right;
        while(i <= left && j < arr.size()) {
            if(arr[i] <= arr[j]) {
                result = min(result, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        return result;
    }
};