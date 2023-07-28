impl Solution {
    pub fn min_operations(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let len = nums.len();
        let mut ans = len;
        let mut i = 0;
        for j in 0..len {
            while nums[j] - nums[i] >= len as i32 {
                i += 1;
            }
            ans = ans.min(len - (j - i + 1));
        }
        ans as i32
    }
}