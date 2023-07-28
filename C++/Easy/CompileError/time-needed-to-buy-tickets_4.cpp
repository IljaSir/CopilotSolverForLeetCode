class Solution {
public:
    int timeRequiredToBuy(vector<int>& tickets, int k) {
        
        int n = tickets.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += tickets[i];
        }
        int ans = 0;
        int cur = 0;
        while (sum > 0) {
            for (int i = 0; i < n && sum > 0; i++) {
                if (i == k) {
                    sum -= 1;
                    cur += 1;
                    if (sum == 0) {
                        ans += cur;
                        cur = 0;
                    }
                } else {
                    if (tickets[i] > 0) {
                        tickets[i] -= 1;
                        sum -= 1;
                        cur += 1;
                    } else {
                        ans += cur;
                        cur = 0;
                    }
                }
            }
        }
        return ans;
    }
    int timeRequiredToBuy2(vector<int>& tickets, int k) {
        int n = tickets.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += tickets[i];
        }
        int ans = 0;
        int cur = 0;
        while (sum > 0) {
            for (int i = 0; i < n && sum > 0; i++) {
                if (tickets[i] > 0) {
                    tickets[i] -= 1;
                    sum -= 1;
                    cur += 1;
                    if (i == k) {
                        ans += cur;
                        cur = 0;
                    }
                } else {
                    ans += cur;
                    cur = 0;
                }
            }
        }
        return ans;
    }
    int timeRequiredToBuy1(vector<int>& tickets, int k) {
        int n = tickets.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += tickets[i];
        }
        int ans = 0;
        int cur = 0;
        while (sum > 0) {
            for (int i = 0; i < n && sum > 0; i++) {
                if (tickets[i] > 0) {
                    tickets[i] -= 1;
                    sum -= 1;
                    cur += 1;
                    if (i ==
    }
};