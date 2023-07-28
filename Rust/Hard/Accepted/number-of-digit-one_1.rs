impl Solution {
    pub fn count_digit_one(n: i32) -> i32 {
        
        let mut n = n;
        let mut res = 0;
        let mut i = 1;
        while i <= n {
            let divider = i * 10;
            res += (n / divider) * i + i32::min(i32::max(n % divider - i + 1, 0), i);
            i = divider;
        }
        res
    }
}