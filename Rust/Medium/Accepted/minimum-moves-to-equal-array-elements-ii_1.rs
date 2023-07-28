impl Solution {
    pub fn min_moves2(nums: Vec<i32>) -> i32 {
        

        let mut nums = nums;
        nums.sort();
        let mut i = 0;
        let mut j = nums.len() - 1;
        let mut ans = 0;
        while i < j {
            ans += nums[j] - nums[i];
            i += 1;
            j -= 1;
        }
        ans
    }
}