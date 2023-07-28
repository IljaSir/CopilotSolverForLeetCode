impl Solution {
    pub fn first_missing_positive(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        let n = nums.len();
        for i in 0..n {
            while nums[i] > 0 && nums[i] <= n as i32 && nums[nums[i] as usize - 1] != nums[i] {
                nums.swap(i, nums[i] as usize - 1);
            }
        }
        for i in 0..n {
            if nums[i] != (i + 1) as i32 {
                return (i + 1) as i32;
            }
        }
        (n + 1) as i32
    }
}