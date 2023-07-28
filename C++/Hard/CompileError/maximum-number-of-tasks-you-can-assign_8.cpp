class Solution {
public:
    int maxTaskAssign(vector<int>& tasks, vector<int>& workers, int pills, int strength) {
        
        sort(workers.begin(), workers.end());
        sort(tasks.begin(), tasks.end());
        int n = tasks.size();
        int m = workers.size();
        int l = 0, r = n;
        while (l < r) {
            int mid = (l + r) / 2;
            if (check(tasks, workers, pills, strength, mid)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l - 1;
    }
    bool check(vector<int>& tasks, vector<int>& workers, int pills, int strength, int mid) {
        int rn res;
    }
};