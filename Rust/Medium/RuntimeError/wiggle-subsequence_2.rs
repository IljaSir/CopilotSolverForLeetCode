impl Solution {
    pub fn wiggle_max_length(nums: Vec<i32>) -> i32 {
        

        let mut pos = 1;
        let mut neg = 1;
        for i in 0..nums.len() {
            if nums[i] > nums[i - 1] {
                pos = neg + 1;
            } else if nums[i] < nums[i - 1] {
                neg = pos + 1;
            }
        }
        return pos.max(neg);
    }
}