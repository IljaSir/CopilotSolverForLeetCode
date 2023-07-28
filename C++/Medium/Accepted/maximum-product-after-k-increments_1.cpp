class Solution {
public:
    int maximumProduct(vector<int>& nums, int k) {
        
        priority_queue<int, vector<int>, greater<int>> minheap;
        priority_queue<int> maxheap;
        for (int i = 0; i < nums.size(); i++) {
            minheap.push(nums[i]);
            maxheap.push(nums[i]);
        }
        for (int i = 0; i < k; i++) {
            int min = minheap.top();
            int max = maxheap.top();
            minheap.pop();
            maxheap.pop();
            minheap.push(min + 1);
            maxheap.push(max + 1);
        }
        int64_t product = 1;
        while (!minheap.empty()) {
            product = product * minheap.top() % 1000000007;
            minheap.pop();
        }
        return product;
    }
};