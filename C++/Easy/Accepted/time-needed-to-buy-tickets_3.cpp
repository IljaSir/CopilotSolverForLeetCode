class Solution {
public:
    int timeRequiredToBuy(vector<int>& tickets, int k) {
        
        int time = 0;
        int i = 0;
        while (true) {
            if (tickets[i] > 0) {
                tickets[i]--;
                time++;
                if (tickets[i] == 0 && k == i) {
                    break;
                }
            }
            i++;
            if (i == tickets.size()) {
                i = 0;
            }
        }
        return time;
    }
};