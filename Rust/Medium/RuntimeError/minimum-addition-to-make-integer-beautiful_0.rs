impl Solution {
    pub fn make_integer_beautiful(n: i64, target: i32) -> i64 {
        
        let mut n = n;
        let mut ans = 0;
        let mut digits = vec![];
        while n > 0 {
            digits.push((n % 10) as i32);
            n /= 10;
        }
        digits.reverse();
        let mut s = digits.iter().sum::<i32>();
        let mut i = 0;
        while s > target {
            ans += (10 - digits[i]) as i64;
            s += 10 - digits[i];
            i += 1;
        }
        ans
    }
}