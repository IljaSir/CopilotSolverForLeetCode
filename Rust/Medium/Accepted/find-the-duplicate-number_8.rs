impl Solution {
    pub fn find_duplicate(nums: Vec<i32>) -> i32 {
        

        let mut nums = nums;
        nums.sort();
        for i in 1..nums.len() {
            if nums[i] == nums[i-1] {
                return nums[i];
            }
        }
        -1
    }
}