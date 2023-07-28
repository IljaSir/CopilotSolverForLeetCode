impl Solution {
    pub fn sum_of_beauties(nums: Vec<i32>) -> i32 {
        
        let mut left_max = vec![0; nums.len()];
        let mut right_min = vec![0; nums.len()];
        left_max[0] = nums[0];
        for i in 1..nums.len() {
            left_max[i] = left_max[i-1].max(nums[i]);
        }
        right_min[nums.len()-1] = nums[nums.len()-1];
        for i in (0..nums.len()-1).rev() {
            right_min[i] = right_min[i+1].min(nums[i]);
        }
        let mut res = 0;
        for i in 1..nums.len()-1 {
            if nums[i] > left_max[i-1] && nums[i] < right_min[i+1] {
                res += 2;
            } else if nums[i-1] < nums[i] && nums[i] < nums[i+1] {
                res += 1;
            }
        }
        res
    }
}