class Solution {
public:
    int timeRequiredToBuy(vector<int>& tickets, int k) {
        
        int n = tickets.size();
        int sum = 0;
        int min = tickets[k];
        for (int i = 0; i < n; i++) {
            if (tickets[i] < min) {
                min = tickets[i];
            }
            sum += tickets[i];
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (tickets[i] == min) {
                if (i == k) {
                    res += tickets[i];
                    break;
                } else {
                    res += tickets[i];
                }
            } else if (tickets[i] > min) {
                if (i == k) {
                    res += tickets[i] - min;
                    break;
                } else {
                    res += tickets[i] - min;
                }
            }
        }
        return res;
    }
    int timeRequiredToBuy2(vector<int>& tickets, int k) {
        int n = tickets.size();
        int sum = 0;
        int min = tickets[k];
        for (int i = 0; i < n; i++) {
            if (tickets[i] < min) {
                min = tickets[i];
            }
            sum += tickets[i];
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (tickets[i] == min) {
                if (i == k) {
                    res += tickets[i];
                    break;
                } else {
                    res += tickets[i];
                }
            } else if (tickets[i] > min) {
                if (i == k) {
                    res += tickets[i] - min;
                    break;
                } else {
                    res += tickets[i] - min;
                }
            }
        }
        return res;
    }
    int timeRequiredToBuy3(vector<int>& tickets, int k) {
        int n = tickets.size();
        int sum = 0;
        int min = tickets[k];
        for (int i = 0; i < n; i++) {
            if (tickets[i] < min) {
                min = tickets[i];
            }
            sum += tickets[i];
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (tickets[i] == min) {
                if (i == k)
    }
};