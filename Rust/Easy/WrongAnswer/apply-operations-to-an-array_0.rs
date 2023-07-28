impl Solution {
    pub fn apply_operations(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        for i in 0..nums.len() - 1 {
            if nums[i] == nums[i + 1] {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        nums.retain(|&x| x > 0);
        for _ in 0..nums.len() {
            nums.push(0);
        }
        nums
    }
}