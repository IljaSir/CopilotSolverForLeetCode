class Solution {
public:
    int getWinner(vector<int>& arr, int k) {
        
        int n = arr.size();
        int count = 0;
        int win = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > win) {
                win = arr[i];
                count = 1;
            }
            else {
                count++;
            }
            if (count == k) {
                break;
            }
        }
        return win;
    }
};