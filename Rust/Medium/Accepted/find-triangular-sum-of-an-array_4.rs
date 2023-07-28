impl Solution {
    pub fn triangular_sum(nums: Vec<i32>) -> i32 {
        
        if nums.len() == 1 {
            return nums[0];
        }
        let mut new_nums = Vec::new();
        for i in 0..nums.len()-1 {
            new_nums.push((nums[i] + nums[i+1]) % 10);
        }
        return Solution::triangular_sum(new_nums);
    }
}