class Solution {
public:
    int findBestValue(vector<int>& arr, int target) {
        
        int n = arr.size();
        sort(arr.begin(), arr.end());
        int sum = 0, i = 0;
        while (i < n && sum + arr[i] * (n - i) < target) {
            sum += arr[i];
            i++;
        }
        if (i == n) {
            return arr[n - 1];
        }
        int res = (target - sum) / (n - i);
        int diff1 = abs(target - sum - res * (n - i));
        int diff2 = abs(target - sum - (res + 1) * (n - i));
        if (diff1 <= diff2) {
            return res;
        }
        return res + 1;
    }
};