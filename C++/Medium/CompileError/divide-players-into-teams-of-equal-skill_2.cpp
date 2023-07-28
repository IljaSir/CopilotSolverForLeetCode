class Solution {
public:
    long long dividePlayers(vector<int>& skill) {
        
        int n = skill.size();
        sort(skill.begin(), skill.end());
        long long sum = 0;
        for (int i = 0; i < n / 2; ++i) {
            sum += (long long)skill[i] * skill[n - i - 1];
        }
        return sum;
    }
    int maxProduct(vector<int>& nums) {
        int n = nums.size();
        int max1 = 0, max2 = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] > max1) {
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2) {
                max2 = nums[i];
            }
        }
        return (max1 - 1) * (max2 - 1);
    }
    int maxProduct(vector<int>& nums) {
        int n = nums.size();
        int max1 = 0, max2 = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] > max1) {
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2) {
                max2 = nums[i];
            }
        }
        return (max1 - 1) * (max2 - 1);
    }
    int maxProduct(vector<int>& nums) {
        int n = nums.size();
        int max1 = 0, max2 = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] > max1) {
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2) {
                max2 = nums[i];
            }
        }
        return (max1 - 1) * (max2 - 1);
    }
};