impl Solution {
    pub fn min_days(n: i32) -> i32 {
        
        let mut n = n as i64;
        let mut memo = vec![0; 2000001];
        let mut q = std::collections::VecDeque::new();
        q.push_back(n);
        while let Some(x) = q.pop_front() {
            if x <= 1 {
                return memo[x as usize];
            }
            if memo[x as usize] > 0 {
                continue;
            }
            memo[x as usize] = memo[(x - 1) as usize] + 1;
            q.push_back(x - 1);
            if x % 2 == 0 {
                memo[x as usize] = std::cmp::min(memo[x as usize], memo[(x / 2) as usize] + 1);
                q.push_back(x / 2);
            }
            if x % 3 == 0 {
                memo[x as usize] = std::cmp::min(memo[x as usize], memo[(x / 3) as usize] + 1);
                q.push_back(x / 3);
            }
        }
        memo[n as usize]
    }
}