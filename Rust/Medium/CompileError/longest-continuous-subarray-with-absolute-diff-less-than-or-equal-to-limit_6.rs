impl Solution {
    pub fn longest_subarray(nums: Vec<i32>, limit: i32) -> i32 {
        
        let mut max = std::collections::VecDeque::new();
        let mut min = std::collections::VecDeque::new();
        let mut i = 0;
        let mut j = 0;
        let mut result = 0;
        while j < nums.len() {
            while let Some(&x) = max.front_back() {
                if nums[x] >= nums[j] {
                    break;
                }
                max.pop_back();
            }
            max.push_back(j);
            while let Some(&x) = min.front_back() {
                if nums[x] <= nums[j] {
                    break;
                }
                min.pop_back();
            }
            min.push_back(j);
            while nums[max[0]] - nums[min[0]] > limit {
                i += 1;
                if max[0] < i {
                    max.pop_front();
                }
                if min[0] < i {
                    min.pop_front();
                }
            }
            result = result.max(j - i + 1);
            j += 1;
        }
        result as i32
    }
}