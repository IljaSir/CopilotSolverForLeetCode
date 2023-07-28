impl Solution {
    pub fn count_subarrays(nums: Vec<i32>, min_k: i32, max_k: i32) -> i64 {
        
        let mut ans = 0;
        let mut min = 0;
        let mut max = 0;
        let mut i = 0;
        let mut j = 0;
        while j < nums.len() {
            if nums[j] >= min_k {
                min += 1;
            }
            if nums[j] > max_k {
                max += 1;
            }
            while min > 0 && max == 0 {
                ans += min as i64;
                if nums[i] >= min_k {
                    min -= 1;
                }
                if nums[i] > max_k {
                    max -= 1;
                }
                i += 1;
            }
            j += 1;
        }
        ans
    }
}