impl Solution {
    pub fn max_sliding_window(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut res = vec![];
        let mut q = std::collections::VecDeque::new();
        for i in 0..nums.len() {
            while !q.is_empty() && nums[*q.back().unwrap()] < nums[i] {
                q.pop_back();
            }
            q.push_back(i);
            if i >= k as usize - 1 {
                while *q.front().unwrap() <= i - k as usize {
                    q.pop_front();
                }
                res.push(nums[*q.front().unwrap()]);
            }
        }
        res
    }
}