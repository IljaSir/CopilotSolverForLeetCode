class Solution {
public:
    int getWinner(vector<int>& arr, int k) {
        
        int n = arr.size();
        int winner = arr[0];
        int win_count = 0;
        for (int i = 1; i < n; ++i) {
            if (arr[i] > winner) {
                winner = arr[i];
                win_count = 1;
            } else {
                win_count++;
            }
            if (win_count == k) {
                break;
            }
        }
        return winner;
    }
};