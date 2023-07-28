impl Solution {
    pub fn shuffle(nums: Vec<i32>, n: i32) -> Vec<i32> {
        
        let mut ans = Vec::new();
        for i in 0..n as usize {
            ans.push(nums[i]);
            ans.push(nums[i + n as usize]);
        }
        ans
    }
}