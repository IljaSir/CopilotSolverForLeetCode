impl Solution {
    pub fn sum_of_beauties(nums: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut left = vec![0; nums.len()];
        let mut right = vec![0; nums.len()];
        let mut max = nums[0];
        for i in 1..nums.len()-1 {
            left[i] = max;
            max = max.max(nums[i]);
        }
        let mut min = nums[nums.len()-1];
        for i in (1..nums.len()-1).rev() {
            right[i] = min;
            min = min.min(nums[i]);
            if nums[i] > left[i] && nums[i] < right[i] {
                res += 2;
            } else if nums[i-1] < nums[i] && nums[i] < nums[i+1] {
                res += 1;
            }
        }
        res
    }
}