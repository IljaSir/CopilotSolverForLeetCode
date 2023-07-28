impl Solution {
    pub fn max_result(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut dp = vec![0; nums.len()];
        dp[0] = nums[0];
        let mut heap = std::collections::BinaryHeap::new();
        heap.push(nums[0]);
        for i in 1..nums.len() {
            while heap.peek().unwrap() + k as i32 < i as i32 {
                heap.pop();
            }
            dp[i] = heap.peek().unwrap() + nums[i];
            heap.push(dp[i]);
        }
        dp[nums.len() - 1]
    }
}