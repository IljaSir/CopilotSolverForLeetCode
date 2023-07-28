class Solution {
public:
    int maxProfitAssignment(vector<int>& difficulty, vector<int>& profit, vector<int>& worker) {
        
        vector<pair<int,int>> jobs;
        int n = difficulty.size();
        for(int i = 0; i < n; i++){
            jobs.push_back({difficulty[i], profit[i]});
        }
        sort(jobs.begin(), jobs.end());
        sort(worker.begin(), worker.end());
        int j = 0, maxp = 0, res = 0;
        for(int i = 0; i < worker.size(); i++){
            while(j < n && jobs[j].first <= worker[i]){
                maxp = max(maxp, jobs[j].second);
                j++;
            }
            res += maxp;
        }
        return res;
    }
};