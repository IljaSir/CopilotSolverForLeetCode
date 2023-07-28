class Solution {
public:
    int getWinner(vector<int>& arr, int k) {
        
        int n = arr.size();
        int win = 0;
        int winner = arr[0];
        for(int i=1; i<n; i++){
            if(arr[i] > winner){
                winner = arr[i];
                win = 0;
            }
            win++;
            if(win == k) break;
        }
        return winner;
    }
};