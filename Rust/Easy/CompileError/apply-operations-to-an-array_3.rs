impl Solution {
    pub fn apply_operations(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        let mut i = 0;
        while i < nums.len() - 1 {
            if nums[i] == nums[i + 1] {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
            i += 1;
        }
        let mut result = Vec::new();
        for n in nums {
            if n != 0 {
                result.push(n);
            }
        }
        let zeros = nums.len() - result.len();
        for _ in 0..zeros {
            result.push(0);
        }
        result
    }
}