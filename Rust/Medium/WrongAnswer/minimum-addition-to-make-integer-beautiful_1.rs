impl Solution {
    pub fn make_integer_beautiful(n: i64, target: i32) -> i64 {
        
        let mut n = n;
        let mut res = 0;
        let mut digits = vec![];
        while n > 0 {
            digits.push((n % 10) as i32);
            n /= 10;
        }
        digits.reverse();
        let mut i = 0;
        let mut sum = 0;
        while i < digits.len() {
            sum += digits[i];
            if sum > target {
                let diff = sum - target;
                let mut j = i;
                while j < digits.len() {
                    let mut x = 10 - digits[j];
                    while x - diff >= 0 {
                        x -= diff;
                        res += 1;
                    }
                    sum -= digits[j];
                    j += 1;
                }
                break;
            }
            i += 1;
        }
        res
    }
}