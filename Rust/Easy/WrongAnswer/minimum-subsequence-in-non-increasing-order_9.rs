impl Solution {
    pub fn min_subsequence(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        nums.sort();
        let mut sum = 0;
        for &num in &nums {
            sum += num;
        }
        let mut sub = 0;
        for (i, &num) in nums.iter().rev().enumerate() {
            sub += num;
            if sub > sum - sub {
                return nums[i..].to_vec();
            }
        }
        unreachable!()
    }
}