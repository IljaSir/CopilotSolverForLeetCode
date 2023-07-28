class Solution {
public:
    int minDays(vector<int>& bloomDay, int m, int k) {
        
        int n = bloomDay.size();
        if (n < m * k) return -1;
        
        int l = 1, r = 1e9;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(bloomDay, m, k, mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }
    
    bool check(vector<int>& bloomDay, int m, int k, int day) {
        int cnt = 0;
        for (int i = 0; i < bloomDay.size() && cnt < m; i++) {
            if (bloomDay[i] <= day) {
                int j = i;
                while (j < bloomDay.size() && bloomDay[j] <= day) j++;
                cnt += (j - i) / k;
                i = j - 1;
            }
        }
        return cnt >= m;
    }
};