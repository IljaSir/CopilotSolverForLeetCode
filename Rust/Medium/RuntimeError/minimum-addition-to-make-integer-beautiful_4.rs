impl Solution {
    pub fn make_integer_beautiful(n: i64, target: i32) -> i64 {
        
        let mut n = n;
        let mut sum = 0;
        let mut multiplier = 1;
        while n > 0 {
            sum += (n % 10) as i32;
            n /= 10;
            multiplier *= 10;
        }
        if sum <= target {
            0
        } else {
            let mut multiplier = 1;
            let mut res = 0;
            while sum > target {
                let digit = (n / multiplier) % 10;
                sum -= digit as i32;
                res += (10 - digit) as i64 * multiplier;
                multiplier *= 10;
                sum += 9;
            }
            res
        }
    }
}