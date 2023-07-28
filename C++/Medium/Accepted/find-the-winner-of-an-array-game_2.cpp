class Solution {
public:
    int getWinner(vector<int>& arr, int k) {
        
        int n = arr.size();
        int win = arr[0];
        int win_count = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > win) {
                win = arr[i];
                win_count = 1;
            } else {
                win_count++;
            }
            if (win_count == k) {
                break;
            }
        }
        return win;
    }
};