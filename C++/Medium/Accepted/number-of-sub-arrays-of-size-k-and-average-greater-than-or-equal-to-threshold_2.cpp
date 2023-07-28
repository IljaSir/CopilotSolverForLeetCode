class Solution {
public:
    int numOfSubarrays(vector<int>& arr, int k, int threshold) {
        
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int res = 0;
        if (sum / k >= threshold) {
            res++;
        }
        for (int i = k; i < arr.size(); i++) {
            sum = sum + arr[i] - arr[i - k];
            if (sum / k >= threshold) {
                res++;
            }
        }
        return res;
    }
};