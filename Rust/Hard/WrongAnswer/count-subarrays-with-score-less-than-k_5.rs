impl Solution {
    pub fn count_subarrays(nums: Vec<i32>, k: i64) -> i64 {
        
        let mut sum = 0;
        let mut res = 0;
        let mut queue = std::collections::VecDeque::new();
        for i in 0..nums.len() {
            sum += nums[i] as i64;
            while !queue.is_empty() && sum - queue.front().unwrap() >= k {
                queue.pop_front();
            }
            res += queue.len() as i64;
            while !queue.is_empty() && sum <= *queue.back().unwrap() {
                queue.pop_back();
            }
            queue.push_back(sum);
        }
        res
    }
}