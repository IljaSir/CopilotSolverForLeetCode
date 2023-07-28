impl Solution {
    pub fn intersection(nums: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut result = nums[0].clone();
        for i in 1..nums.len() {
            result = result.into_iter().filter(|x| nums[i].contains(x)).collect();
        }
        result
    }
}