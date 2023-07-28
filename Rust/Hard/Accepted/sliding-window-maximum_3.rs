impl Solution {
    pub fn max_sliding_window(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut res = Vec::new();
        let mut deque = std::collections::VecDeque::new();
        for (i, &num) in nums.iter().enumerate() {
            while !deque.is_empty() && num >= nums[*deque.back().unwrap()] {
                deque.pop_back();
            }
            deque.push_back(i);
            if i as i32 + 1 >= k {
                while !deque.is_empty() && *deque.front().unwrap() < i - k as usize + 1 {
                    deque.pop_front();
                }
                res.push(nums[*deque.front().unwrap()]);
            }
        }
        res
    }
}