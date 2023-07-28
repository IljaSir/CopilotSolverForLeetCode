impl Solution {
    pub fn count_subarrays(nums: Vec<i32>, min_k: i32, max_k: i32) -> i64 {
        
        let mut res = 0;
        let mut i = 0;
        while i < nums.len() {
            let mut min = nums[i];
            let mut max = nums[i];
            let mut j = i;
            while j < nums.len() {
                min = min.min(nums[j]);
                max = max.max(nums[j]);
                if min >= min_k && max <= max_k {
                    res += 1;
                } else {
                    break;
                }
                j += 1;
            }
            i += 1;
        }
        res
    }
}