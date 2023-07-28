impl Solution {
    pub fn max_product(nums: Vec<i32>) -> i32 {
        
        let mut max1 = 0;
        let mut max2 = 0;
        for i in 0..nums.len() {
            if nums[i] > max1 {
                max2 = max1;
                max1 = nums[i];
            } else if nums[i] > max2 {
                max2 = nums[i];
            }
        }
        (max1 - 1) * (max2 - 1)
    }
}