impl Solution {
    pub fn min_sub_array_len(target: i32, nums: Vec<i32>) -> i32 {
        

        let mut sum = 0;
        let mut l = 0;
        let mut r = 0;
        let mut min = nums.len() + 1;
        while r < nums.len() {
            sum += nums[r];
            while sum >= target {
                min = min.min(r - l + 1);
                sum -= nums[l];
                l += 1;
            }
            r += 1;
        }
        if min == nums.len() + 1 {
            0
        } else {
            min as i32
        }
    }
}