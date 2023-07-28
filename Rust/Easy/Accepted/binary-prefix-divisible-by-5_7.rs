impl Solution {
    pub fn prefixes_div_by5(nums: Vec<i32>) -> Vec<bool> {
        
        let mut result = vec![];
        let mut num = 0;
        for i in nums.iter() {
            num = (num << 1) + i;
            result.push(num % 5 == 0);
            num = num % 5;
        }
        result
    }
}