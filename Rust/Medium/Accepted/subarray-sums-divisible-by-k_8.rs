impl Solution {
    pub fn subarrays_div_by_k(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut sum = 0;
        let mut cnt = vec![0; k as usize];
        cnt[0] = 1;
        for i in 0..nums.len() {
            sum += nums[i];
            sum %= k;
            if sum < 0 {
                sum += k;
            }
            cnt[sum as usize] += 1;
        }
        let mut ans = 0;
        for i in 0..k as usize {
            ans += cnt[i] * (cnt[i] - 1) / 2;
        }
        ans
    }
}