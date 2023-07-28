class Solution {
public:
    int minimizedMaximum(int n, vector<int>& quantities) {
        
        sort(quantities.begin(), quantities.end());
        int l = 1, r = quantities.back();
        while (l < r) {
            int mid = (l + r) >> 1;
            long long sum = 0;
            for (int i : quantities)
                sum += i / mid;
            if (sum >= n)
                l = mid + 1;
            else
                r = mid;
        }
        return l - 1;
    }
};