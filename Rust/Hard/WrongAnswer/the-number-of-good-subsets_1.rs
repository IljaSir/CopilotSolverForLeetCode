impl Solution {
    pub fn number_of_good_subsets(nums: Vec<i32>) -> i32 {
        
        let mut primes = vec![2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31];
        let mut cnt = vec![0; 32];
        let mut ans = 1;
        let mut mod_num = 1_000_000_007;
        for i in 0..nums.len() {
            cnt[nums[i] as usize] += 1;
        }
        for i in 0..primes.len() {
            let mut max_cnt = 0;
            let mut cur = primes[i];
            while cur <= 30 {
                max_cnt = max_cnt.max(cnt[cur as usize]);
                cur += primes[i];
            }
            ans = ans * (max_cnt + 1) % mod_num;
        }
        for i in 2..=30 {
            let mut is_prime = true;
            for j in 0..primes.len() {
                if i % primes[j] == 0 {
                    is_prime = false;
                    break;
                }
            }
            if is_prime {
                ans = ans * (cnt[i as usize] + 1) % mod_num;
            }
        }
        ans = ans - 1;
        if ans < 0 {
            ans += mod_num;
        }
        ans
    }
}