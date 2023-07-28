impl Solution {
    pub fn min_sub_array_len(target: i32, nums: Vec<i32>) -> i32 {
        

        let mut sum = 0;
        let mut left = 0;
        let mut ans = 0;
        for right in 0..nums.len() {
            sum += nums[right];
            while sum >= target {
                if ans == 0 || right - left + 1 < ans {
                    ans = right - left + 1;
                }
                sum -= nums[left];
                left += 1;
            }
        }
        ans as i32
    }
}