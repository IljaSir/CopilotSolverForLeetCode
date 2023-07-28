impl Solution {
    pub fn longest_subarray(nums: Vec<i32>, limit: i32) -> i32 {
        
        let mut max = 0;
        let mut left = 0;
        let mut right = 0;
        let mut maxq = std::collections::VecDeque::new();
        let mut minq = std::collections::VecDeque::new();
        while right < nums.len() {
            while let Some(&last) = maxq.back() {
                if last < nums[right] {
                    maxq.pop_back();
                } else {
                    break;
                }
            }
            while let Some(&last) = minq.back() {
                if last > nums[right] {
                    minq.pop_back();
                } else {
                    break;
                }
            }
            maxq.push_back(nums[right]);
            minq.push_back(nums[right]);
            while maxq.front().unwrap() - minq.front().unwrap() > limit {
                if maxq.front().unwrap() == &nums[left] {
                    maxq.pop_front();
                }
                if minq.front().unwrap() == &nums[left] {
                    minq.pop_front();
                }
                left += 1;
            }
            max = max.max(right - left + 1);
            right += 1;
        }
        max as i32
    }
}