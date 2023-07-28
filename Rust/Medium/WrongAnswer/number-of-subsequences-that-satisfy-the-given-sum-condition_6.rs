impl Solution {
    pub fn num_subseq(nums: Vec<i32>, target: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut ans = 0;
        let mut p = 1;
        let mut j = nums.len() - 1;
        for i in 0..=j {
            while j > i && nums[i] + nums[j] > target {
                j -= 1;
            }
            ans = (ans + p) % 1_000_000_007;
            p = (p * 2) % 1_000_000_007;
        }
        ans
    }
}