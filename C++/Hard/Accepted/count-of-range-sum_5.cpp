class Solution {
public:
    int countRangeSum(vector<int>& nums, int lower, int upper) {
        
        int n = nums.size();
        long long sum = 0;
        vector<long long> sums;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            sums.push_back(sum);
        }
        return mergeSort(sums, lower, upper, 0, n - 1);
    }
    int mergeSort(vector<long long>& sums, int lower, int upper, int left, int right) {
        if (left == right) {
            return sums[left] >= lower && sums[left] <= upper;
        }
        int mid = (left + right) >> 1;
        int n1 = mergeSort(sums, lower, upper, left, mid);
        int n2 = mergeSort(sums, lower, upper, mid + 1, right);
        int ret = n1 + n2;
        int i = left, l = mid + 1, r = mid + 1;
        while (i <= mid) {
            while (l <= right && sums[l] - sums[i] < lower) l++;
            while (r <= right && sums[r] - sums[i] <= upper) r++;
            ret += r - l;
            i++;
        }
        vector<long long> sorted(right - left + 1);
        int p1 = left, p2 = mid + 1, p = 0;
        while (p1 <= mid || p2 <= right) {
            long long v1 = p1 <= mid ? sums[p1] : INT64_MAX;
            long long v2 = p2 <= right ? sums[p2] : INT64_MAX;
            if (v1 < v2) {
                sorted[p++] = v1;
                p1++;
            } else {
                sorted[p++] = v2;
                p2++;
            }
        }
        for (int i = 0; i < sorted.size(); i++) {
            sums[left + i] = sorted[i];
        }
        return ret;
    }
};