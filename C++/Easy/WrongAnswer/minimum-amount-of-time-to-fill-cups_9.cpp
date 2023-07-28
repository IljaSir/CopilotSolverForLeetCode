class Solution {
public:
    int fillCups(vector<int>& amount) {
        
        int n = amount.size();
        int res = 0;
        int i = 0;
        while (i < n) {
            if (amount[i] > 0) {
                amount[i]--;
                res++;
            }
            i++;
        }
        int j = 0;
        while (j < n) {
            if (amount[j] > 0) {
                amount[j]--;
                res++;
            }
            j++;
        }
        int k = 0;
        while (k < n) {
            if (amount[k] > 0) {
                amount[k]--;
                res++;
            }
            k++;
        }
        return res;
    }
    int minTimeToFill(vector<int>& amount) {
        int res = 0;
        int n = amount.size();
        int i = 0;
        while (i < n) {
            if (amount[i] > 0) {
                res = fillCups(amount);
                break;
            }
            i++;
        }
        return res;
    }
};