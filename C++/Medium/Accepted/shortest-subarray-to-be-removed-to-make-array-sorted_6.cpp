class Solution {
public:
    int findLengthOfShortestSubarray(vector<int>& arr) {
        
        int n = arr.size();
        int start = 0;
        while(start+1 < n && arr[start] <= arr[start+1]) {
            start++;
        }
        if(start == n-1) {
            return 0;
        }
        int end = n-1;
        while(end-1 >= 0 && arr[end] >= arr[end-1]) {
            end--;
        }
        int ans = min(n-start-1, end);
        int i = 0, j = end;
        while(i <= start && j < n) {
            if(arr[j] >= arr[i]) {
                ans = min(ans, j-i-1);
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }
};