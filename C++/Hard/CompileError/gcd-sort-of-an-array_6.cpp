class Solution {
public:
    bool gcdSort(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> temp = nums;
        sort(temp.begin(), temp.end());
        vector<int> parent(n);
        vector<int> size(n);
        iota(parent.begin(), parent.end(), 0);
        fill(size.begin(), size.end(), 1);
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (gcd(nums[i], nums[j]) != 1) {
                    merge(parent, size, i, j);
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            if (find(parent, i) != find(parent, lower_bound(temp.begin(), temp.end(), nums[i]) - temp.begin())) {
                return false;
            }
        }
        return true;
    }
};