class Solution {
public:
    int countRangeSum(vector<int>& nums, int lower, int upper) {
        
        int n = nums.size();
        vector<long> sum(n+1, 0);
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        return countWhileMergeSort(sum, 0, n+1, lower, upper);
    }
    int countWhileMergeSort(vector<long>& sum, int start, int end, int lower, int upper) {
        if (end - start <= 1) return 0;
        int mid = (start + end) / 2;
        int count = countWhileMergeSort(sum, start, mid, lower, upper) + countWhileMergeSort(sum, mid, end, lower, upper);
        int j = mid, k = mid, t = mid;
        vector<long> cache(end - start, 0);
        for (int i = start, r = 0; i < mid; i++, r++) {
            while (k < end && sum[k] - sum[i] < lower) k++;
            while (j < end && sum[j] - sum[i] <= upper) j++;
            while (t < end && sum[t] < sum[i]) cache[r++] = sum[t++];
            cache[r] = sum[i];
            count += j - k;
        }
        copy(cache.begin(), cache.begin() + t - start, sum.begin() + start);
        return count;
    }
};