impl Solution {
    pub fn get_concatenation(nums: Vec<i32>) -> Vec<i32> {
        
        let mut ans: Vec<i32> = nums.clone();
        ans.extend(nums);
        ans
    }
}