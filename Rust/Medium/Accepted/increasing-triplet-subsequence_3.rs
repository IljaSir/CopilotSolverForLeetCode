impl Solution {
    pub fn increasing_triplet(nums: Vec<i32>) -> bool {
        

        let mut first = std::i32::MAX;
        let mut second = std::i32::MAX;
        for i in 0..nums.len() {
            if nums[i] <= first {
                first = nums[i];
            } else if nums[i] <= second {
                second = nums[i];
            } else {
                return true;
            }
        }
        false
    }
}