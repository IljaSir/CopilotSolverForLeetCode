class Solution {
public:
    int fillCups(vector<int>& amount) {
        
        int res = 0;
        int water = 0;
        while (amount[0] > 0 || amount[1] > 0 || amount[2] > 0) {
            if (amount[0] > 0 && amount[1] > 0) {
                amount[0]--;
                amount[1]--;
                water += 2;
            } else if (amount[1] > 0 && amount[2] > 0) {
                amount[1]--;
                amount[2]--;
                water += 2;
            } else if (amount[0] > 0 && amount[2] > 0) {
                amount[0]--;
                amount[2]--;
                water += 2;
            } else if (amount[0] > 0) {
                amount[0]--;
                water += 1;
            } else if (amount[1] > 0) {
                amount[1]--;
                water += 1;
            } else if (amount[2] > 0) {
                amount[2]--;
                water += 1;
            }
            res++;
        }
        return res;
    }
    
    int minimumTimeRequired(vector<int>& amount, int k) {
        int n = amount.size();
        int res = INT_MAX;
        vector<int> workers(k, 0);
        sort(amount.begin(), amount.end());
        do {
            res = min(res, dfs(amount, workers, n - 1));
        } while (prev_permutation(amount.begin(), amount.end()));
        return res;
    }
    
    int dfs(vector<int>& amount, vector<int>& workers, int index) {
        if (index < 0) {
            return *max_element(workers.begin(), workers.end());
        }
        int res = INT_MAX;
        for (int i = 0; i < workers.size(); i++) {
            workers[i] += amount[index];
            res = min(res, dfs(amount, workers, index - 1));
            workers[i] -= amount[index];
        }
        return res;
    }
};