impl Solution {
    pub fn longest_subarray(nums: Vec<i32>, limit: i32) -> i32 {
        
        let mut max = std::collections::VecDeque::new();
        let mut min = std::collections::VecDeque::new();
        let mut left = 0;
        let mut right = 0;
        let mut res = 0;
        while right < nums.len() {
            while !max.is_empty() && max.back().unwrap() < &nums[right] {
                max.pop_back();
            }
            max.push_back(nums[right]);
            while !min.is_empty() && min.back().unwrap() > &nums[right] {
                min.pop_back();
            }
            min.push_back(nums[right]);
            while max.front().unwrap() - min.front().unwrap() > limit {
                if max.front().unwrap() == &nums[left] {
                    max.pop_front();
                }
                if min.front().unwrap() == &nums[left] {
                    min.pop_front();
                }
                left += 1;
            }
            res = res.max(right - left + 1);
            right += 1;
        }
        res as i32
    }
}