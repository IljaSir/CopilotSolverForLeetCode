impl Solution {
    pub fn find_max_k(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        for i in (0..nums.len()).rev() {
            if nums[i] <= 0 {
                return -1;
            }
            if nums[i] == -nums[i] {
                return nums[i];
            }
        }
        -1
    }
}