impl Solution {
    pub fn third_max(nums: Vec<i32>) -> i32 {
        
        let mut max1 = std::i32::MIN;
        let mut max2 = std::i32::MIN;
        let mut max3 = std::i32::MIN;
        for i in 0..nums.len() {
            if nums[i] > max1 {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if nums[i] > max2 && nums[i] < max1 {
                max3 = max2;
                max2 = nums[i];
            } else if nums[i] > max3 && nums[i] < max2 {
                max3 = nums[i];
            }
        }
        if max3 == std::i32::MIN {
            max1
        } else {
            max3
        }
    }
}