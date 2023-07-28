impl Solution {
    pub fn check_possibility(nums: Vec<i32>) -> bool {
        

        let mut cnt = 0;
        let mut prev = std::i32::MIN;
        for i in 0..nums.len() {
            if nums[i] < prev {
                cnt += 1;
                if i > 1 && nums[i] < nums[i - 2] {
                    nums[i] = nums[i - 1];
                }
            }
            prev = nums[i];
        }
        cnt <= 1
    }
}