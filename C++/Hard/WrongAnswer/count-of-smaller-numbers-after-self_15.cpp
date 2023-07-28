class Solution {
public:
    vector<int> countSmaller(vector<int>& nums) {
        
        vector<int> res;
        int n = nums.size();
        if (n == 0) {
            return res;
        }
        vector<pair<int, int>> v;
        for (int i = 0; i < n; i++) {
            v.push_back({nums[i], i});
        }
        vector<int> count(n, 0);
        mergeSort(v, count);
        return count;
    }
    void mergeSort(vector<pair<int, int>>& v, vector<int>& count) {
        int n = v.size();
        if (n == 1) {
            return;
        }
        int mid = n / 2;
        vector<pair<int, int>> left(v.begin(), v.begin() + mid);
        vector<pair<int, int>> right(v.begin() + mid, v.end());
        mergeSort(left, count);
        mergeSort(right, count);
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.size() && j < right.size()) {
            if (left[i].first <= right[j].first) {
                v[k++] = left[i++];
            } else {
                count[left[i].second] += (left.size() - i);
                v[k++] = right[j++];
            }
        }
        while (i < left.size()) {
            v[k++] = left[i++];
        }
        while (j < right.size()) {
            v[k++] = right[j++];
        }
    }
};