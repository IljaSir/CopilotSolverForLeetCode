impl Solution {
    pub fn clumsy(n: i32) -> i32 {
        
        let mut res = n;
        let mut i = n - 1;
        let mut sign = 0;
        while i > 0 {
            match sign {
                0 => res *= i,
                1 => res /= i,
                2 => res += i,
                3 => res -= i,
                _ => (),
            }
            sign = (sign + 1) % 4;
            i -= 1;
        }
        res
    }
}