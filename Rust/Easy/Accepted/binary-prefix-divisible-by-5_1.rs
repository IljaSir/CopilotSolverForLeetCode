impl Solution {
    pub fn prefixes_div_by5(nums: Vec<i32>) -> Vec<bool> {
        
        let mut result = Vec::new();
        let mut num = 0;
        for i in nums {
            num = (num * 2 + i) % 5;
            result.push(num == 0);
        }
        result
    }
}