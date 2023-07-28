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
        for d in digits {
            sum += d;
            if sum > target {
                break;
            }
        }
        let mut res = 0;
        let mut carry = 0;
        for d in digits {
            let mut need = target - sum + carry;
            if need < 0 {
                need = 0;
            }
            if d + need <= 9 {
                res = res * 10 + d + need;
                carry = 0;
            } else {
                res = res * 10 + d + need - 10;
                carry = 1;
            }
            sum -= d;
        }
        res
    }
}