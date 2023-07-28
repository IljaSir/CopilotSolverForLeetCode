impl Solution {
    pub fn moves_to_make_zigzag(nums: Vec<i32>) -> i32 {
        
        let mut n = nums.len();
        let mut nums = nums;
        let mut ans = 0;
        for i in 0..n {
            if i % 2 == 0 {
                if i > 0 && nums[i] >= nums[i - 1] {
                    ans += nums[i] - nums[i - 1] + 1;
                    nums[i] = nums[i - 1] - 1;
                }
                if i + 1 < n && nums[i] >= nums[i + 1] {
                    ans += nums[i] - nums[i + 1] + 1;
                    nums[i] = nums[i + 1] - 1;
                }
            } else {
                if i > 0 && nums[i] <= nums[i - 1] {
                    ans += nums[i - 1] - nums[i] + 1;
                    nums[i - 1] = nums[i] - 1;
                }
                if i + 1 < n && nums[i] <= nums[i + 1] {
                    ans += nums[i + 1] - nums[i] + 1;
                    nums[i + 1] = nums[i] - 1;
                }
            }
        }
        ans
    }
}