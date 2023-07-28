class Solution {
public:
    vector<int> kthSmallestPrimeFraction(vector<int>& arr, int k) {
        
        int n = arr.size();
        double l = 0, r = 1;
        while (l < r) {
            double mid = l + (r - l) / 2;
            int cnt = 0, p = 0, q = 1;
            for (int i = 0, j = 0; i < n; ++i) {
                while (j < n && arr[i] > mid * arr[j]) ++j;
                cnt += n - j;
                if (j < n && p * arr[j] < q * arr[i]) p = arr[i], q = arr[j];
            }
            if (cnt == k) return {p, q};
            if (cnt < k) l = mid;
            else r = mid;
        }
        return {};unt - 1];
                break;
            }
        }
        retrn ans;
    }
};