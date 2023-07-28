impl Solution {
    pub fn apply_operations(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        let n = nums.len();
        for i in 0..n-1 {
            if nums[i] == nums[i+1] {
                nums[i] *= 2;
                nums[i+1] = 0;
            }
        }
        nums.retain(|&x| x != 0);
        let mut zeros = vec![0; n-nums.len()];
        nums.append(&mut zeros);
        nums
    }
}