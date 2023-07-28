impl Solution {
    pub fn simplified_fractions(n: i32) -> Vec<String> {
        
        let mut res = Vec::new();
        for i in 1..n {
            for j in i+1..=n {
                if Solution::gcd(i, j) == 1 {
                    res.push(format!("{}/{}", i, j));
                }
            }
        }
        res
    }
    fn gcd(a: i32, b: i32) -> i32 {
        if b == 0 {
            a
        } else {
            Solution::gcd(b, a % b)
        }
    }
}