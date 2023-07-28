impl Solution {
    pub fn num_subseq(nums: Vec<i32>, target: i32) -> i32 {
        
        let n = nums.len();
        let mut nums = nums;
        let mut ans = 0;
        nums.sort();
        let mut left = 0;
        let mut right = n - 1;
        let mut pow2 = vec![1; n];
        for i in 1..n {
            pow2[i] = pow2[i - 1] * 2 % 1000000007;
        }
        while left <= right {
            if nums[left] + nums[right] <= target {
                ans = (ans + pow2[right - left]) % 1000000007;
                left += 1;
            } else {
                right -= 1;
            }
        }
        ans as i32
    }
}