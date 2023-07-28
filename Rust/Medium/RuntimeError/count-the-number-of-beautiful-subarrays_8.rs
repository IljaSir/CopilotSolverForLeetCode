impl Solution {
    pub fn beautiful_subarrays(nums: Vec<i32>) -> i64 {
        
        let mut ans = 0;
        let mut odd = 0;
        let mut cnt = vec![0; 1];
        for i in 0..nums.len() {
            if nums[i] % 2 == 1 {
                odd += 1;
            }
            ans += cnt[odd as usize];
            cnt[odd as usize] += 1;
        }
        ans as i64
    }
}