class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        
        int n = nums.size();
        int a = nums[0], b = nums[0];
        int cnt_a = 0, cnt_b = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == a) {
                cnt_a++;
            } else if (nums[i] == b) {
                cnt_b++;
            } else if (cnt_a == 0) {
                a = nums[i];
                cnt_a++;
            } else if (cnt_b == 0) {
                b = nums[i];
                cnt_b++;
            } else {
                cnt_a--;
                cnt_b--;
            }
        }
        cnt_a = cnt_b = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == a) {
                cnt_a++;
            } else if (nums[i] == b) {
                cnt_b++;
            }
        }
        vector<int> ans;
        if (cnt_a > n / 3) {
            ans.push_back(a);
        }
        if (cnt_b > n / 3) {
            ans.push_back(b);
        }
        return ans;
    }
};