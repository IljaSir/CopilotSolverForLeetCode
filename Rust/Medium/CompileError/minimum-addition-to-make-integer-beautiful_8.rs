impl Solution {
    pub fn make_integer_beautiful(n: i64, target: i32) -> i64 {
        
        let mut n = n;
        let mut sum = 0;
        let mut digits = 0;
        let mut t = n;
        while t > 0 {
            sum += t % 10;
            t /= 10;
            digits += 1;
        }
        let mut res = 0;
        let mut i = 0;
        while sum > target {
            let d = n % 10;
            let c = 10 - d;
            res += c * 10_i64.pow(i);
            n /= 10;
            n += c;
            sum -= d;
            sum += 9;
            i += 1;
        }
        res
    }
}