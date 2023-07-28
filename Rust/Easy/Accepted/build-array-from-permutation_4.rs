impl Solution {
    pub fn build_array(nums: Vec<i32>) -> Vec<i32> {
        
        let mut ans: Vec<i32> = vec![];
        for i in 0..nums.len() {
            ans.push(nums[nums[i] as usize]);
        }
        ans
    }
}