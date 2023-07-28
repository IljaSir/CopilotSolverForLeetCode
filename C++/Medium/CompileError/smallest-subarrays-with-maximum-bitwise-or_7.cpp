class Solution {
public:
    vector<int> smallestSubarrays(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> res(n, 0);
        stack<int> s;
        for (int i = 0; i < n; i++) {
            int t = nums[i];
            while (!s.empty() && (t | nums[s.top()]) > t) {
                t |= nums[s.top()];
                s.pop();
            }
            s.push(i);
            res[i] = s.size();
        }
        return res;
    }
    vector<int> smallestSubarrays2(vector<int>& nums) {
        int n = nums.size();
        vector<int> res(n, 0);
        stack<int> s;
        for (int i = 0; i < n; i++) {
            int t = nums[i];
            while (!s.empty() && (t | nums[s.top()]) > t) {
                t |= nums[s.top()];
                s.pop();
            }
            while (!s.empty() && nums[s.top()] <= nums[i]) {
                s.pop();
            }
            s.push(i);
            res[i] = s.size();
        }
        return res;
    }
    vector<int> smallestSubarrays3(vector<int>& nums) {
        int n = nums.size();
        vector<int> res(n, 0);
        stack<int> s;
        for (int i = 0; i < n; i++) {
            int t = nums[i];
            while (!s.empty() && (t | nums[s.top()]) > t) {
                t |= nums[s.top()];
                s.pop();
            }
            while (!s.empty() && nums[s.top()] < nums[i]) {
                s.pop();
            }
            s.push(i);
            res[i] = s.size();
        }
        return res;
    }
    vector<int> smallestSubarrays4(vector<int>& nums) {
        int n = nums.size();
        vector<int> res(n, 0);
        stack<int> s;
        for (int i = 0; i < n; i++) {
            int t = nums[i];
            while (!s.empty() && (t | nums[s.top()]) > t) {
                t |= nums[s.top()];
                s.pop();
            }
            while (!s.empty() && nums[s.top()] <= nums[i]) {
                s.pop();
            }
            s.push(i);
            res[i] = i - s.top() +
    }
};