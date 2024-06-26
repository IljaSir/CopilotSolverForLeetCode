impl Solution {
    pub fn num_subseq(nums: Vec<i32>, target: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut ans = 0;
        let mut l = 0;
        let mut r = nums.len() - 1;
        let mut pow = vec![1; nums.len()];
        for i in 1..nums.len() {
            pow[i] = (pow[i - 1] * 2) % 1000000007;
        }
        while l <= r {
            if nums[l] + nums[r] > target {
                r -= 1;
            } else {
                ans = (ans + pow[r - l]) % 1000000007;
                l += 1;
            }
        }
        ans
    }
}