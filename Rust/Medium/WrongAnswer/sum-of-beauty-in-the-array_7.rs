impl Solution {
    pub fn sum_of_beauties(nums: Vec<i32>) -> i32 {
        
        let mut result = 0;
        let mut min = vec![0; nums.len()];
        let mut max = vec![0; nums.len()];
        min[0] = nums[0];
        max[nums.len() - 1] = nums[nums.len() - 1];
        for i in 1..nums.len() {
            min[i] = min[i - 1].min(nums[i]);
        }
        for i in (0..nums.len() - 1).rev() {
            max[i] = max[i + 1].max(nums[i]);
        }
        for i in 1..nums.len() - 1 {
            if min[i - 1] < nums[i] && nums[i] < max[i + 1] {
                result += 2;
            } else if nums[i - 1] < nums[i] && nums[i] < nums[i + 1] {
                result += 1;
            }
        }
        result
    }
}