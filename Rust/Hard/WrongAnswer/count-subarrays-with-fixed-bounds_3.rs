impl Solution {
    pub fn count_subarrays(nums: Vec<i32>, min_k: i32, max_k: i32) -> i64 {
        
        let mut res = 0;
        let mut left = 0;
        let mut right = 0;
        let mut min = 0;
        let mut max = 0;
        while right < nums.len() {
            if nums[right] >= min_k {
                min += 1;
            }
            if nums[right] > max_k {
                max += 1;
            }
            while min > 0 && max > 0 {
                if nums[left] >= min_k {
                    min -= 1;
                }
                if nums[left] > max_k {
                    max -= 1;
                }
                left += 1;
            }
            res += (left) as i64;
            right += 1;
        }
        res
    }
}