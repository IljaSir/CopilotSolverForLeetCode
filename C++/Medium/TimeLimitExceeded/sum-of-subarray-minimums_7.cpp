class Solution {
public:
    int sumSubarrayMins(vector<int>& arr) {
        
        int len = arr.size();
        int sum = 0;
        for (int i = 0; i < len; i++) {
            int min = arr[i];
            for (int j = i; j < len; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                }
                sum += min;
                sum %= 1000000007;
            }
        }
        return sum;
    }
};