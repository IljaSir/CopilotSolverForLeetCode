impl Solution {
    pub fn max_sliding_window(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut ans = vec![];
        let mut q = std::collections::VecDeque::new();
        for i in 0..nums.len() {
            while let Some(&j) = q.back() {
                if nums[j] < nums[i] {
                    q.pop_back();
                } else {
                    break;
                }
            }
            q.push_back(i);
            if let Some(&j) = q.front() {
                if i >= j + k as usize {
                    q.pop_front();
                }
            }
            if i >= k as usize - 1 {
                ans.push(nums[*q.front().unwrap()]);
            }
        }
        ans
    }
}