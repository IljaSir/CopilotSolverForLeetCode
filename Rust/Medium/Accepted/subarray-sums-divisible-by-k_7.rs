impl Solution {
    pub fn subarrays_div_by_k(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut sum = 0;
        let mut cnt = vec![0; k as usize];
        cnt[0] = 1;
        let mut ans = 0;
        for &num in nums.iter() {
            sum += num;
            let m = (sum % k + k) % k;
            ans += cnt[m as usize];
            cnt[m as usize] += 1;
        }
        ans
    }
}