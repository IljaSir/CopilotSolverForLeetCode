impl Solution {
    pub fn max_sliding_window(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let k = k as usize;
        let mut res = Vec::with_capacity(nums.len()-k+1);
        let mut deque = std::collections::VecDeque::with_capacity(k);
        for (i, &n) in nums.iter().enumerate() {
            while let Some(&last) = deque.back() {
                if last < n {
                    deque.pop_back();
                } else {
                    break;
                }
            }
            deque.push_back(n);
            if i >= k {
                if let Some(&first) = deque.front() {
                    if first == nums[i-k] {
                        deque.pop_front();
                    }
                }
            }
            if i >= k-1 {
                res.push(*deque.front().unwrap());
            }
        }
        res
    }
}