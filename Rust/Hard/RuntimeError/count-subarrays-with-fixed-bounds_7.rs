impl Solution {
    pub fn count_subarrays(nums: Vec<i32>, min_k: i32, max_k: i32) -> i64 {
        
        let mut ans = 0;
        let mut cnt = 0;
        let mut min = 0;
        let mut max = 0;
        let mut l = 0;
        let mut r = 0;
        while r < nums.len() {
            if nums[r] >= min_k {
                min += 1;
            }
            if nums[r] > max_k {
                max += 1;
            }
            while max > 0 {
                if nums[l] > max_k {
                    max -= 1;
                }
                l += 1;
            }
            while min > 0 {
                if nums[l] >= min_k {
                    min -= 1;
                }
                cnt += 1;
                l += 1;
            }
            ans += cnt;
            r += 1;
        }
        ans
    }
}