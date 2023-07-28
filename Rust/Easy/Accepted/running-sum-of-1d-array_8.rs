impl Solution {
    pub fn running_sum(nums: Vec<i32>) -> Vec<i32> {
        
        let mut res = Vec::new();
        let mut sum = 0;
        for num in nums.iter() {
            sum += num;
            res.push(sum);
        }
        res
    }
}