impl Solution {
    pub fn max_sub_array(nums: Vec<i32>) -> i32 {
        

        let mut max_sum = nums[0];
        let mut cur_sum = 0;
        for i in 0..nums.len() {
            cur_sum += nums[i];
            if cur_sum > max_sum {
                max_sum = cur_sum;
            }
            if cur_sum < 0 {
                cur_sum = 0;
            }
        }
        max_sum
    }
}