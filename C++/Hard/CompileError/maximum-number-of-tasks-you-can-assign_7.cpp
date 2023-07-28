class Solution {
public:
    int maxTaskAssign(vector<int>& tasks, vector<int>& workers, int pills, int strength) {
        
            ++j;
            ++ans;
        }
        return ans;


        sort(tasks.begin(), tasks.end());
        sort(workers.begin(), workers.end());
        int n = tasks.size();
        int m = workers.size();
        int l = 0;
        int r = n;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (canAssign(tasks, workers, pills, strength, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
};