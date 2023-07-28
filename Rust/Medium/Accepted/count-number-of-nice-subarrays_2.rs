impl Solution {
    pub fn number_of_subarrays(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut ans = 0;
        let mut odd = 0;
        let mut cnt = vec![0; nums.len() + 1];
        cnt[0] = 1;
        for i in 0..nums.len() {
            if nums[i] % 2 == 1 {
                odd += 1;
            }
            if odd >= k {
                ans += cnt[(odd - k) as usize];
            }
            cnt[odd as usize] += 1;
        }
        ans
    }
}