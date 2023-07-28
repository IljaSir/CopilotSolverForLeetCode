impl Solution {
    pub fn make_integer_beautiful(n: i64, target: i32) -> i64 {
        
        let mut n = n;
        let mut count = 0;
        while n > 0 {
            count += n % 10;
            n /= 10;
        }
        let mut result = 0;
        let mut i = 1;
        while count > target {
            let x = (count - target) / 9 + 1;
            result += x * i;
            count -= x * 9;
            i *= 10;
        }
        result
    }
}