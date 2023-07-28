class Solution {
public:
    bool divideArray(vector<int>& nums) {
        
        unordered_map<int, int> mp;
        for (int num : nums) {
            mp[num]++;
        }
        for (auto p : mp) {
            if (p.second % 2 != 0) {
                return false;
            }
        }
        return true;
    }
    bool canArrange(vector<int>& arr, int k) {
        vector<int> nums(k, 0);
        for (int num : arr) {
            nums[(num % k + k) % k]++;
        }
        if (nums[0] % 2 != 0) {
            return false;
        }
        for (int i = 1; i < k; i++) {
            if (nums[i] != nums[k - i]) {
                return false;
            }
        }
        return true;
    }
    bool canArrange(vector<int>& arr, int k) {
        vector<int> nums(k, 0);
        for (int num : arr) {
            nums[(num % k + k) % k]++;
        }
        if (nums[0] % 2 != 0) {
            return false;
        }
        for (int i = 1; i < k; i++) {
            if (nums[i] != nums[k - i]) {
                return false;
            }
        }
        return true;
    }
    bool canArrange(vector<int>& arr, int k) {
        vector<int> nums(k, 0);
        for (int num : arr) {
            nums[(num % k + k) % k]++;
        }
        if (nums[0] % 2 != 0) {
            return false;
        }
        for (int i = 1; i < k; i++) {
            if (nums[i] != nums[k - i]) {
                return false;
            }
        }
        return true;
    }
    bool canArrange(vector<int>& arr, int k) {
        vector<int> nums(k, 0);
        for (int num : arr) {
            nums[(num % k + k) % k]++;
        }
        if (nums[0] % 2 != 0) {
            return false;
        }
        for (int i = 1; i < k; i++) {
            if (nums[i] != nums[k - i]) {
                return false;
            }
        }
        return true;
    }
};