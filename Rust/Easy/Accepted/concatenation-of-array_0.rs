impl Solution {
    pub fn get_concatenation(nums: Vec<i32>) -> Vec<i32> {
        
        let mut ans = vec![];
        for i in 0..nums.len() {
            ans.push(nums[i]);
        }
        for i in 0..nums.len() {
            ans.push(nums[i]);
        }
        ans
    }
}