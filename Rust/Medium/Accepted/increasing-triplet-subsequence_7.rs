impl Solution {
    pub fn increasing_triplet(nums: Vec<i32>) -> bool {
        

        let mut a = std::i32::MAX;
        let mut b = std::i32::MAX;
        for i in 0..nums.len() {
            if nums[i] <= a {
                a = nums[i];
            } else if nums[i] <= b {
                b = nums[i];
            } else {
                return true;
            }
        }
        false
    }
}