class Solution {
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        
        vector<vector<int>> ans;
        vector<int> dist;
        for (int i = 0; i < points.size(); i++) {
            dist.push_back(points[i][0] * points[i][0] + points[i][1] * points[i][1]);
        }
        int l = 0, r = points.size() - 1;
        while (l < r) {
            int i = l, j = r;
            int x = dist[i];
            while (i < j) {
                while (i < j && dist[j] >= x) j--;
                if (i < j) dist[i++] = dist[j];
                while (i < j && dist[i] < x) i++;
                if (i < j) dist[j--] = dist[i];
            }
            dist[i] = x;
            if (i == k) break;
            if (i < k) l = i + 1;
            else r = i - 1;
        }
        for (int i = 0; i < k; i++) {
            ans.push_back(points[i]);
        }
        return ans;
    }
};