impl Solution {
    pub fn min_moves2(nums: Vec<i32>) -> i32 {
        

        let mut nums = nums;
        nums.sort();
        let n = nums.len();
        let mid = nums[n / 2];
        nums.into_iter().map(|v| (v - mid).abs()).sum()
    }
}