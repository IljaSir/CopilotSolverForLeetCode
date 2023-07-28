impl Solution {
    pub fn minimum_operations(nums: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        for i in 0..nums.len() {
            if i % 2 == 0 {
                if nums[i] % 2 == 0 {
                    ans += 1;
                }
            } else {
                if nums[i] % 2 == 1 {
                    ans += 1;
                }
            }
        }
        ans.min(nums.len() - ans) as i32
    }
}