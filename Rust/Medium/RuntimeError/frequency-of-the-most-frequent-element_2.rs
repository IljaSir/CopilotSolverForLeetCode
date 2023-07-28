impl Solution {
    pub fn max_frequency(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut i = 0;
        let mut j = 0;
        let mut sum = 0;
        let mut ans = 1;
        while j < nums.len() {
            sum += (j - i) as i32 * (nums[j] - nums[j - 1]);
            while sum > k {
                sum -= nums[j] - nums[i];
                i += 1;
            }
            ans = ans.max(j - i + 1);
            j += 1;
        }
        ans as i32
    }
}