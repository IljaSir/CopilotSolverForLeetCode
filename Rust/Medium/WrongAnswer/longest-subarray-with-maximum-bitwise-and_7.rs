impl Solution {
    pub fn longest_subarray(nums: Vec<i32>) -> i32 {
        
        let mut pre = nums[0];
        let mut ans = 0;
        for i in 1..nums.len() {
            let cur = pre & nums[i];
            if cur == pre {
                ans += 1;
            } else {
                pre = cur;
                ans = 0;
            }
        }
        ans
    }
}