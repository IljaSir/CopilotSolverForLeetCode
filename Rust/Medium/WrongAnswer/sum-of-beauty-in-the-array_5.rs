impl Solution {
    pub fn sum_of_beauties(nums: Vec<i32>) -> i32 {
        
        let mut left = vec![0; nums.len()];
        let mut right = vec![0; nums.len()];
        let mut min = nums[0];
        let mut max = nums[nums.len()-1];
        for i in 1..nums.len()-1 {
            if nums[i] > min {
                left[i] = 1;
            } else {
                min = nums[i];
            }
        }
        for i in (1..nums.len()-1).rev() {
            if nums[i] < max {
                right[i] = 1;
            } else {
                max = nums[i];
            }
        }
        let mut sum = 0;
        for i in 1..nums.len()-1 {
            if left[i] == 1 && right[i] == 1 {
                sum += 2;
            } else if nums[i-1] < nums[i] && nums[i] < nums[i+1] {
                sum += 1;
            }
        }
        sum
    }
}