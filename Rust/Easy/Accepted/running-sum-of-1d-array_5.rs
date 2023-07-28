impl Solution {
    pub fn running_sum(nums: Vec<i32>) -> Vec<i32> {
        
        let mut sum = 0;
        let mut result = Vec::new();
        for i in nums {
            sum += i;
            result.push(sum);
        }
        result
    }
}