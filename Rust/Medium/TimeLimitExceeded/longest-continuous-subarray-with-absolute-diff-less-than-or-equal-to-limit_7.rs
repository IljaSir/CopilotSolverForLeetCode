impl Solution {
    pub fn longest_subarray(nums: Vec<i32>, limit: i32) -> i32 {
        
        let mut max_q = std::collections::VecDeque::new();
        let mut min_q = std::collections::VecDeque::new();
        let mut result = 0;
        let mut left = 0;
        for (right, &num) in nums.iter().enumerate() {
            while let Some(&last) = max_q.back() {
                if last <= num {
                    max_q.pop_back();
                } else {
                    break;
                }
            }
            while let Some(&last) = min_q.back() {
                if last >= num {
                    min_q.pop_back();
                } else {
                    break;
                }
            }
            max_q.push_back(num);
            min_q.push_back(num);
            while let Some(&max) = max_q.front() {
                if let Some(&min) = min_q.front() {
                    if max - min <= limit {
                        result = result.max(right - left + 1);
                        break;
                    } else {
                        left += 1;
                        if nums[left - 1] == max {
                            max_q.pop_front();
                        }
                        if nums[left - 1] == min {
                            min_q.pop_front();
                        }
                    }
                }
            }
        }
        result as i32
    }
}