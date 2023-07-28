class Solution {
public:
    int getWinner(vector<int>& arr, int k) {
        
        int n = arr.size();
        int mx = max(arr[0], arr[1]);
        int count = 0;
        for(int i = 2; i < n; i++) {
            if(arr[i] > mx) {
                mx = arr[i];
                count = 0;
            }
            count++;
            if(count == k) break;
        }
        return mx;
    }
};