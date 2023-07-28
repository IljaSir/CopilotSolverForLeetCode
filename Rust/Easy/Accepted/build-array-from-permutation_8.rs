impl Solution {
    pub fn build_array(nums: Vec<i32>) -> Vec<i32> {
        
        let mut ans = Vec::new();
        for (i, n) in nums.iter().enumerate() {
            ans.push(nums[*n as usize]);
        }
        ans
    }
}