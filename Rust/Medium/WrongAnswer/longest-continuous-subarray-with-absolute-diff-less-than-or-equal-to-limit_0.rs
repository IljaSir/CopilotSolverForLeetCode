impl Solution {
    pub fn longest_subarray(nums: Vec<i32>, limit: i32) -> i32 {
        
        let mut max_heap = std::collections::BinaryHeap::new();
        let mut min_heap = std::collections::BinaryHeap::new();
        let mut left = 0;
        let mut right = 0;
        let mut res = 1;
        while right < nums.len() {
            max_heap.push(nums[right]);
            min_heap.push(nums[right]);
            while max_heap.peek().unwrap() - min_heap.peek().unwrap() > limit {
                max_heap.pop();
                min_heap.pop();
                left += 1;
            }
            res = res.max(right - left + 1);
            right += 1;
        }
        res as i32
    }
}