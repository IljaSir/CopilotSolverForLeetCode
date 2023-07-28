impl Solution {
    pub fn longest_subarray(nums: Vec<i32>, limit: i32) -> i32 {
        
        let mut max = std::collections::VecDeque::new();
        let mut min = std::collections::VecDeque::new();
        let mut left = 0;
        let mut right = 0;
        let mut ans = 0;
        while right < nums.len() {
            while let Some(&v) = max.front() {
                if v < nums[right] {
                    max.pop_front();
                } else {
                    break;
                }
            }
            while let Some(&v) = min.front() {
                if v > nums[right] {
                    min.pop_front();
                } else {
                    break;
                }
            }
            max.push_front(nums[right]);
            min.push_front(nums[right]);
            while max.back().unwrap() - min.back().unwrap() > limit {
                if nums[left] == *max.back().unwrap() {
                    max.pop_back();
                }
                if nums[left] == *min.back().unwrap() {
                    min.pop_back();
                }
                left += 1;
            }
            ans = std::cmp::max(ans, right - left + 1);
            right += 1;
        }
        ans as i32
    }
}