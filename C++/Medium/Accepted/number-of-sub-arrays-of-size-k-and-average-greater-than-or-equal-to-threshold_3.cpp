class Solution {
public:
    int numOfSubarrays(vector<int>& arr, int k, int threshold) {
        
        int sum = 0;
        for (int i = 0; i < k; ++i) {
            sum += arr[i];
        }
        int result = 0;
        if (sum / k >= threshold) {
            result++;
        }
        for (int i = k; i < arr.size(); ++i) {
            sum = sum - arr[i - k] + arr[i];
            if (sum / k >= threshold) {
                result++;
            }
        }
        return result;
    }
};