class Solution {
public:
    vector<long long> maximumSegmentSum(vector<int>& nums, vector<int>& removeQueries) {
        
        vector<long long> res(removeQueries.size());
        int n = nums.size();
        set<int> s;
        s.insert(-1);
        s.insert(n);
        long long sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
        }
        for(int i = 0; i < removeQueries.size(); i++) {
            int idx = removeQueries[i];
            auto it = s.upper_bound(idx);
            int right = *it;
            it--;
            int left = *it;
            sum -= nums[idx];
            s.insert(idx);
            if(left + 1 < idx) {
                res[i] = max(res[i], sum);
            }
            if(idx + 1 < right) {
                res[i] = max(res[i], sum);
            }
        }
        for(int i = removeQueries.size() - 2; i >= 0; i--) {
            res[i] = max(res[i], res[i + 1]);
        }
        return res;
    }
};