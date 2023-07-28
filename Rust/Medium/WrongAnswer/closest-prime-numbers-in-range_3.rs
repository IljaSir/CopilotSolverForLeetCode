impl Solution {
    pub fn closest_primes(left: i32, right: i32) -> Vec<i32> {
        
        let (mut i, mut j) = (left, right);
        while i > 0 && j > 0 {
            if Solution::is_prime(i) && Solution::is_prime(j) {
                return vec![i, j];
            }
            i -= 1;
            j += 1;
        }
        vec![-1, -1]
    }
    fn is_prime(n: i32) -> bool {
        if n == 1 {
            return false;
        }
        let mut i = 2;
        while i * i <= n {
            if n % i == 0 {
                return false;
            }
            i += 1;
        }
        true
    }
}