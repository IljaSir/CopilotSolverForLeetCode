impl Solution {
    pub fn make_integer_beautiful(n: i64, target: i32) -> i64 {
        
        let mut n = n;
        let mut sum = 0;
        let mut num = 0;
        let mut digits = Vec::new();
        while n > 0 {
            let d = (n % 10) as i32;
            sum += d;
            digits.push(d);
            n /= 10;
        }
        digits.reverse();
        let mut i = 0;
        while sum > target {
            let d = digits[i];
            let diff = (d + 1) * 10_i32.pow(digits.len() - 1 - i) as i32 - d * 10_i32.pow(digits.len() - 1 - i) as i32;
            sum -= d;
            sum += 1;
            num += diff as i64;
            i += 1;
        }
        num
    }
}