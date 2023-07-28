impl Solution {
    pub fn num_prime_arrangements(n: i32) -> i32 {
        
        let mut count = 0;
        let mut i = 2;
        while i <= n {
            let mut j = 2;
            while j * j <= i {
                if i % j == 0 {
                    break;
                }
                j += 1;
            }
            if j * j > i {
                count += 1;
            }
            i += 1;
        }
        let mut ans = 1;
        for i in 1..=count {
            ans = (ans * i) % 1_000_000_007;
        }
        for i in 1..=(n - count) {
            ans = (ans * i) % 1_000_000_007;
        }
        ans
    }
}