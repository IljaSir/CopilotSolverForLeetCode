impl Solution {
    pub fn count_subarrays(nums: Vec<i32>, k: i64) -> i64 {
        
        let n = nums.len();
        let mut sum = vec![0; n + 1];
        for i in 0..n {
            sum[i + 1] = sum[i] + nums[i];
        }
        let mut res = 0;
        let mut deque = Vec::new();
        for i in 0..=n {
            while !deque.is_empty() && sum[i] - sum[deque[0]] >= k {
                deque.remove(0);
            }
            res += deque.len();
            while !deque.is_empty() && sum[i] <= sum[*deque.last().unwrap()] {
                deque.pop();
            }
            deque.push(i);
        }
        res as i64
    }
}