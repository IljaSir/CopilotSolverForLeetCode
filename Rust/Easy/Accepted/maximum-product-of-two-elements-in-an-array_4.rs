impl Solution {
    pub fn max_product(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut second = 0;
        for i in 0..nums.len() {
            if nums[i] > max {
                second = max;
                max = nums[i];
            } else if nums[i] > second {
                second = nums[i];
            }
        }
        (max - 1) * (second - 1)
    }
}