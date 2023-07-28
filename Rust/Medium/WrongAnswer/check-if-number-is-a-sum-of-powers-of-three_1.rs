impl Solution {
    pub fn check_powers_of_three(n: i32) -> bool {
        
        let mut n = n;
        let mut res = 0;
        let mut i = 0;
        while n > 0 {
            res += (n % 3) * 3_i32.pow(i);
            n /= 3;
            i += 1;
        }
        res == n
    }
}