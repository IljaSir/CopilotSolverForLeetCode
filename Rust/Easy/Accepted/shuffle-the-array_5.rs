impl Solution {
    pub fn shuffle(nums: Vec<i32>, n: i32) -> Vec<i32> {
        
        let mut result = vec![];
        let n = n as usize;
        for i in 0..n {
            result.push(nums[i]);
            result.push(nums[n + i]);
        }
        result
    }
}