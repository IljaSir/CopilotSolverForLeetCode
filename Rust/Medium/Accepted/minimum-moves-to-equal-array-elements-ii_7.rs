impl Solution {
    pub fn min_moves2(nums: Vec<i32>) -> i32 {
        

        let mut nums = nums;
        nums.sort_unstable();
        let mut res = 0;
        let mut i = 0;
        let mut j = nums.len() - 1;
        while i < j {
            res += nums[j] - nums[i];
            i += 1;
            j -= 1;
        }
        res
    }
}