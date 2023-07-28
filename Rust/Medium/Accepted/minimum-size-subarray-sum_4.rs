impl Solution {
    pub fn min_sub_array_len(target: i32, nums: Vec<i32>) -> i32 {
        

        let mut sum = 0;
        let mut l = 0;
        let mut r = 0;
        let mut ans = std::i32::MAX;
        while r < nums.len() {
            sum += nums[r];
            while sum >= target {
                ans = std::cmp::min(ans, (r - l + 1) as i32);
                sum -= nums[l];
                l += 1;
            }
            r += 1;
        }
        if ans == std::i32::MAX {
            return 0;
        }
        ans
    }
}