impl Solution {
    pub fn longest_subarray(nums: Vec<i32>, limit: i32) -> i32 {
        
        let mut max = std::collections::VecDeque::new();
        let mut min = std::collections::VecDeque::new();
        let mut i = 0;
        let mut j = 0;
        let mut res = 0;
        while j < nums.len() {
            while !max.is_empty() && nums[*max.back().unwrap()] < nums[j] {
                max.pop_back();
            }
            while !min.is_empty() && nums[*min.back().unwrap()] > nums[j] {
                min.pop_back();
            }
            max.push_back(j);
            min.push_back(j);
            while nums[*max.front().unwrap()] - nums[*min.front().unwrap()] > limit {
                i += 1;
                if *max.front().unwrap() < i {
                    max.pop_front();
                }
                if *min.front().unwrap() < i {
                    min.pop_front();
                }
            }
            res = res.max(j - i + 1);
            j += 1;
        }
        res as i32
    }
}