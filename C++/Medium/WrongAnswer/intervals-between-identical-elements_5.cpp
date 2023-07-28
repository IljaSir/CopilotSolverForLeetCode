class Solution {
public:
    vector<long long> getDistances(vector<int>& arr) {
        
        int n = arr.size();
        vector<long long> ret(n, 0);
        unordered_map<int, int> last;
        for (int i = 0; i < n; ++i) {
            if (last.count(arr[i])) {
                ret[i] = ret[i - 1] + i - last[arr[i]];
            }
            last[arr[i]] = i;
        }
        return ret;
    }
    vector<int> getSumOfIntervals(vector<int>& arr) {
        int n = arr.size();
        vector<int> ret(n, 0);
        vector<long long> left = getDistances(arr);
        reverse(arr.begin(), arr.end());
        vector<long long> right = getDistances(arr);
        reverse(right.begin(), right.end());
        for (int i = 0; i < n; ++i) {
            ret[i] = left[i] + right[i];
        }
        return ret;
    }
    vector<int> sumOfBeauties(vector<int>& nums) {
        int n = nums.size();
        vector<int> ret(n, 0);
        vector<int> left(n, 0);
        vector<int> right(n, 0);
        left[0] = nums[0];
        for (int i = 1; i < n; ++i) {
            left[i] = max(left[i - 1], nums[i]);
        }
        right[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            right[i] = min(right[i + 1], nums[i]);
        }
        vector<int> sum = getSumOfIntervals(nums);
        for (int i = 1; i < n - 1; ++i) {
            if (left[i - 1] < nums[i] && nums[i] < right[i + 1]) {
                ret[i] = 2;
            } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                ret[i] = 1;
            }
            ret[i] += sum[i];
        }
        return ret;
    }
};