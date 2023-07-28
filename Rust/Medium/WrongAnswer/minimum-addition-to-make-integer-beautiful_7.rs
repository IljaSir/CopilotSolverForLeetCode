impl Solution {
    pub fn make_integer_beautiful(n: i64, target: i32) -> i64 {
        
        let mut n = n;
        let mut ans = 0;
        let mut target = target as i64;
        let mut digits = vec![];
        while n > 0 {
            digits.push(n % 10);
            n /= 10;
            target -= 1;
        }
        digits.reverse();
        let mut i = 0;
        while target > 0 {
            if i >= digits.len() {
                ans += target * 9;
                break;
            }
            if digits[i] == 9 {
                i += 1;
            } else {
                let delta = 9 - digits[i];
                if delta <= target {
                    ans += delta * (10i64.pow((digits.len() - i - 1) as u32));
                    target -= delta;
                    digits[i] = 9;
                    i += 1;
                } else {
                    ans += target * (10i64.pow((digits.len() - i - 1) as u32));
                    break;
                }
            }
        }
        ans
    }
}