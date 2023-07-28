impl Solution {
    pub fn third_max(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        nums.reverse();
        let mut count = 1;
        let mut i = 1;
        while i < nums.len() {
            if nums[i] != nums[i - 1] {
                count += 1;
            }
            if count == 3 {
                return nums[i];
            }
            i += 1;
        }
        nums[0]
    }
}