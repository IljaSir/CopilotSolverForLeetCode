impl Solution {
    pub fn running_sum(nums: Vec<i32>) -> Vec<i32> {
        
        let mut sum = 0;
        let mut result = vec![];
        for i in 0..nums.len() {
            sum += nums[i];
            result.push(sum);
        }
        result
    }
}