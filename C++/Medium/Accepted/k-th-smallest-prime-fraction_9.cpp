class Solution {
public:
    vector<int> kthSmallestPrimeFraction(vector<int>& arr, int k) {
        
        int n = arr.size();
        priority_queue<pair<double, pair<int, int>>> q;
        for(int i = 0; i < n-1; i++) {
            q.push({-1.0*arr[i]/arr[n-1], {i, n-1}});
        }
        while(k > 1) {
            auto cur = q.top();
            q.pop();
            if(cur.second.second > cur.second.first + 1) {
                q.push({-1.0*arr[cur.second.first]/arr[cur.second.second-1], {cur.second.first, cur.second.second-1}});
            }
            k--;
        }
        return {arr[q.top().second.first], arr[q.top().second.second]};
    }
};