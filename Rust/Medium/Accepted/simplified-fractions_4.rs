impl Solution {
    pub fn simplified_fractions(n: i32) -> Vec<String> {
        
        let mut res = Vec::new();
        for d in 2..=n {
            for n in 1..d {
                if Self::gcd(n, d) == 1 {
                    res.push(format!("{}/{}", n, d));
                }
            }
        }
        res
    }
    fn gcd(a: i32, b: i32) -> i32 {
        if b == 0 {
            a
        } else {
            Self::gcd(b, a % b)
        }
    }
}