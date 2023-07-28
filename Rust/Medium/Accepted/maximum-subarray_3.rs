impl Solution {
    pub fn max_sub_array(nums: Vec<i32>) -> i32 {
        

        let mut max = nums[0];
        let mut sum = 0;
        for i in 0..nums.len() {
            if sum < 0 {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            if sum > max {
                max = sum;
            }
        }
        max
    }
}