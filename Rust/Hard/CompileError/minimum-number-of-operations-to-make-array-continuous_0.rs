impl Solution {
    pub fn min_operations(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut nums = nums;
        nums.sort();
        let mut ans = n as i32;
        for i in 0..n {
            let j = nums.lower_bound(&(nums[i] + n as i32));
            ans = ans.min(n as i32 - (j - i) as i32);
        }
        ans
    }
}