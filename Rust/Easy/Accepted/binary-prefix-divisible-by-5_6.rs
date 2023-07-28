impl Solution {
    pub fn prefixes_div_by5(nums: Vec<i32>) -> Vec<bool> {
        
        let mut result = Vec::new();
        let mut current = 0;
        for i in 0..nums.len() {
            current = (current * 2 + nums[i]) % 5;
            result.push(current == 0);
        }
        result
    }
}