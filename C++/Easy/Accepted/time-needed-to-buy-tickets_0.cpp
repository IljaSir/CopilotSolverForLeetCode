class Solution {
public:
    int timeRequiredToBuy(vector<int>& tickets, int k) {
        
        int n = tickets.size();
        int ans = 0;
        while (true) {
            bool flag = false;
            for (int i = 0; i < n; i++) {
                if (tickets[i] > 0) {
                    tickets[i]--;
                    ans++;
                    if (i == k && tickets[i] == 0) {
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) break;
        }
        return ans;
    }
};