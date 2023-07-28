class Solution {
public:
    int timeRequiredToBuy(vector<int>& tickets, int k) {
        
        int n = tickets.size();
        int sum = 0;
        int i = k;
        while (true) {
            if (tickets[i] > 0) {
                tickets[i]--;
                sum++;
            }
            if (i == n - 1) {
                i = 0;
            } else {
                i++;
            }
            if (tickets[i] == 0) {
                break;
            }
        }
        return sum;
    }
};