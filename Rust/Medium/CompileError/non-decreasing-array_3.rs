impl Solution {
    pub fn check_possibility(nums: Vec<i32>) -> bool {
        

        let mut cnt = 0;
        for i in 1..nums.len() {
            if nums[i] < nums[i - 1] {
                cnt += 1;
                if i - 2 >= 0 && nums[i] < nums[i - 2] {
                    nums[i] = nums[i - 1];
                }
            }
        }
        cnt <= 1
    }
}