impl Solution {
    pub fn make_integer_beautiful(n: i64, target: i32) -> i64 {
        
        let mut n = n;
        let mut sum = 0;
        let mut digits = Vec::new();
        while n > 0 {
            digits.push(n % 10);
            n /= 10;
        }
        digits.reverse();
        for &d in digits.iter() {
            sum += d as i32;
        }
        let mut i = 0;
        while sum > target {
            let mut d = digits[i];
            while d < 9 && sum - d as i32 + (d + 1) as i32 <= target {
                d += 1;
            }
            sum -= d as i32;
            sum += (d + 1) as i32;
            digits[i] = d + 1;
            i += 1;
        }
        digits.iter().fold(0, |acc, &d| acc * 10 + d as i64)
    }
}