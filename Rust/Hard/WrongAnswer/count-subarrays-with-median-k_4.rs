impl Solution {
    pub fn count_subarrays(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut ans = 0;
        let mut pre = vec![0; nums.len() + 1];
        for i in 0..nums.len() {
            pre[i + 1] = pre[i] + (nums[i] < k) as i32;
        }
        let mut cnt = vec![0; nums.len() + 1];
        for i in 0..=nums.len() {
            ans += cnt[pre[i] as usize];
            cnt[pre[i] as usize] += 1;
        }
        ans
    }
}