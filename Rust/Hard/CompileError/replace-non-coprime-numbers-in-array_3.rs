impl Solution {
    pub fn replace_non_coprimes(nums: Vec<i32>) -> Vec<i32> {
        
        let mut ans = vec![0; nums.len()];
        let mut primes = vec![0; 10_001];
        let mut i = 2;
        while i < 100 {
            if primes[i] == 0 {
                let mut j = i * i;
                while j < 10_001 {
                    primes[j] = i;
                    j += i;
                }
            }
            i += 1;
        }
        let mut max = 0;
        for i in 0..nums.len() {
            let mut n = nums[i];
            while primes[n] > 0 {
                n /= primes[n];
            }
            ans[i] = max;
            max = std::cmp::max(max, n);
        }
        for i in 0..nums.len() {
            ans[i] = if ans[i] == 0 { nums[i] } else { ans[i] };
        }
        ans
    }
}