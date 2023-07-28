impl Solution {
    pub fn max_sliding_window(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let k = k as usize;
        let mut q = std::collections::VecDeque::new();
        let mut res = Vec::new();
        for i in 0..nums.len() {
            while !q.is_empty() && q.front().unwrap() < &(i + 1 - k) {
                q.pop_front();
            }
            while !q.is_empty() && nums[q.back().unwrap()] < nums[i] {
                q.pop_back();
            }
            q.push_back(i);
            if i + 1 >= k {
                res.push(nums[q.front().unwrap()]);
            }
        }
        res
    }
}