impl Solution {
    pub fn min_days(n: i32) -> i32 {
        
        let mut memo = vec![-1; n as usize + 1];
        //println!("n={}", n);
        Self::f(n, &mut memo)
    }
    pub fn f(n: i32, memo: &mut Vec<i32>) -> i32 {
        if n <= 1 {
            return n;
        }
        if memo[n as usize] != -1 {
            return memo[n as usize];
        }
        let r = 1 + n.min(Self::f(n / 2, memo) + n % 2 + Self::f(n / 3, memo) + n % 3);
        memo[n as usize] = r;
        r
    }
}