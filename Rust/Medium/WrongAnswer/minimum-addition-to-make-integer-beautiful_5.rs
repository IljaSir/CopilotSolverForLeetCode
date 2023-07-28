impl Solution {
    pub fn make_integer_beautiful(n: i64, target: i32) -> i64 {
        
        let mut n = n;
        let mut target = target;
        let mut ans = 0;
        let mut digits = vec![];
        while n > 0 {
            digits.push(n % 10);
            n /= 10;
        }
        digits.reverse();
        let mut i = 0;
        while i < digits.len() {
            if digits[i] as i32 <= target {
                target -= digits[i] as i32;
                i += 1;
            } else {
                let mut j = i;
                while j < digits.len() && digits[j] as i32 > target {
                    j += 1;
                }
                if j == digits.len() {
                    ans += (target + 1) as i64 * 10_i64.pow((digits.len() - i - 1) as u32);
                    break;
                } else {
                    ans += (target + 1) as i64 * 10_i64.pow((digits.len() - i - 1) as u32);
                    digits[j] -= 1;
                    target = 9;
                    i = j;
                }
            }
        }
        ans
    }
}