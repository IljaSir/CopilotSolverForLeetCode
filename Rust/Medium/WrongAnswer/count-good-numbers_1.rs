impl Solution {
    pub fn count_good_numbers(n: i64) -> i32 {
        
        let mut ans = 1;
        for i in 0..n/2 {
            ans = ans * 5 % 1000000007;
        }
        for i in 0..n-n/2 {
            ans = ans * 4 % 1000000007;
        }
        ans as i32
    }
}