impl Solution {
    pub fn min_moves2(nums: Vec<i32>) -> i32 {
        

        let mut nums = nums;
        nums.sort();
        let mut res = 0;
        let mid = nums[nums.len() / 2];
        for n in nums {
            res += (n - mid).abs();
        }
        res
    }
}