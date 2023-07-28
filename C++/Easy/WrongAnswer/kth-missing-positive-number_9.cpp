class Solution {
public:
    int findKthPositive(vector<int>& arr, int k) {
        
        int i = 0, j = 0;
        int n = arr.size();
        while (j < n && arr[j] <= k) {
            if (i + 1 != arr[j]) {
                k--;
            }
            i = arr[j];
            j++;
        }
        return k + i;
    }
};