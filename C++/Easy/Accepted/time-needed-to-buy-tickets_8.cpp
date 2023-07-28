class Solution {
public:
    int timeRequiredToBuy(vector<int>& tickets, int k) {
        
        int n = tickets.size();
        int q = 0;
        int i = 0;
        while (true) {
            if (tickets[i] > 0) {
                tickets[i]--;
                q++;
            }
            if (i == k && tickets[i] == 0) break;
            i = (i + 1) % n;
        }
        return q;
    }
};