impl Solution {
    pub fn sum_of_beauties(nums: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        let mut max = vec![0; nums.len()];
        let mut min = vec![0; nums.len()];
        max[0] = nums[0];
        min[nums.len()-1] = nums[nums.len()-1];
        for i in 1..nums.len() {
            max[i] = max[i-1].max(nums[i]);
            min[nums.len()-1-i] = min[nums.len()-i].min(nums[nums.len()-1-i]);
        }
        for i in 1..nums.len()-1 {
            if nums[i] > max[i-1] && nums[i] < min[i+1] {
                sum += 2;
            } else if nums[i-1] < nums[i] && nums[i] < nums[i+1] {
                sum += 1;
            }
        }
        sum
    }
}