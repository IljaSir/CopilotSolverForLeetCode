impl Solution {
    pub fn get_concatenation(nums: Vec<i32>) -> Vec<i32> {
        
        let mut ans = Vec::new();
        ans.extend(nums.iter());
        ans.extend(nums.iter());
        ans
    }
}