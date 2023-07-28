impl Solution {
    pub fn count_subarrays(nums: Vec<i32>, k: i64) -> i64 {
        
        let mut ans = 0;
        let mut sum = 0;
        let mut left = 0;
        for (right, &num) in nums.iter().enumerate() {
            sum += num as i64;
            while sum * (right - left + 1) as i64 >= k {
                sum -= nums[left] as i64;
                left += 1;
            }
            ans += (right - left + 1) as i64;
        }
        ans
    }
}