class Solution {
public:
    int maximumTop(vector<int>& nums, int k) {
        
        int len = nums.size();
        if (len == 1) return -1;
        if (len == 2) {
            if (k == 1) return max(nums[0], nums[1]);
            else return -1;
        }
        priority_queue<int> q;
        for (int i = 0; i < len; i++) {
            q.push(nums[i]);
        }
        int res = 0;
        int remove = 0;
        while (k > 0 && !q.empty()) {
            int top = q.top();
            q.pop();
            if (top == remove) {
                // remove the same element
                k--;
                remove++;
            } else {
                // remove the different element
                k -= 2;
                remove++;
                q.push(top);
            }
        }
        if (q.empty()) return -1;
        else return q.top();
    }
};