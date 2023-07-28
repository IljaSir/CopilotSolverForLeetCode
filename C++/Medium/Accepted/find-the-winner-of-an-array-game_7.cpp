class Solution {
public:
    int getWinner(vector<int>& arr, int k) {
        
        int n = arr.size();
        int i = 1;
        int win = arr[0];
        int cnt = 0;
        while (i < n) {
            if (arr[i] > win) {
                win = arr[i];
                cnt = 0;
            }
            i++;
            cnt++;
            if (cnt == k) {
                return win;
            }
        }
        return win;
    }
};