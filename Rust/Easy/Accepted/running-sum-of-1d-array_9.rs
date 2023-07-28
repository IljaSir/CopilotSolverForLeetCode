impl Solution {
    pub fn running_sum(nums: Vec<i32>) -> Vec<i32> {
        
        let mut rs = vec![];
        let mut sum = 0;
        for i in 0..nums.len() {
            sum += nums[i];
            rs.push(sum);
        }
        rs
    }
}