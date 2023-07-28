impl Solution {
    pub fn min_days(n: i32) -> i32 {
        
        let mut n = n as u32;
        let mut memo = vec![0; (n + 1) as usize];
        memo[0] = 0;
        memo[1] = 1;
        for i in 2..=n {
            memo[i as usize] = 1 + memo[(i - 1) as usize];
            if i % 2 == 0 {
                memo[i as usize] = memo[i as usize].min(1 + memo[(i / 2) as usize]);
            }
            if i % 3 == 0 {
                memo[i as usize] = memo[i as usize].min(1 + memo[(i / 3) as usize]);
            }
        }
        memo[n as usize]
    }
}