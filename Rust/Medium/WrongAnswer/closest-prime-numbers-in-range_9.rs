impl Solution {
    pub fn closest_primes(left: i32, right: i32) -> Vec<i32> {
        
        let mut ans = vec![-1,-1];
        let mut min_gap = right - left;
        let mut num1 = left;
        let mut num2 = right;
        
        while num1 <= right {
            if Self::is_prime(num1) {
                if num1 < num2 {
                    num2 = num1;
                }
                if num1 - num2 < min_gap {
                    min_gap = num1 - num2;
                    ans[0] = num2;
                    ans[1] = num1;
                }
            }
            num1 += 1;
        }
        ans
    }
    
    fn is_prime(n: i32) -> bool {
        if n == 2 {
            return true;
        }
        if n % 2 == 0 {
            return false;
        }
        let mut i = 3;
        while i * i <= n {
            if n % i == 0 {
                return false;
            }
            i += 2;
        }
        true
    }
}