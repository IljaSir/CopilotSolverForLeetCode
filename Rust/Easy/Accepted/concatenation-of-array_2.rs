impl Solution {
    pub fn get_concatenation(nums: Vec<i32>) -> Vec<i32> {
        
        let mut ans = Vec::new();
        for i in nums.iter() {
            ans.push(*i);
        }
        for i in nums.iter() {
            ans.push(*i);
        }
        ans
    }
}