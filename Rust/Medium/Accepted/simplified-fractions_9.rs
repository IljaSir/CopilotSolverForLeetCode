impl Solution {
    pub fn simplified_fractions(n: i32) -> Vec<String> {
        
        let mut res = vec![];
        let mut i = 1;
        while i < n {
            let mut j = i + 1;
            while j <= n {
                if Solution::gcd(i, j) == 1 {
                    res.push(format!("{}/{}", i, j));
                }
                j += 1;
            }
            i += 1;
        }
        res
    }
    pub fn gcd(a: i32, b: i32) -> i32 {
        if b == 0 {
            a
        } else {
            Solution::gcd(b, a % b)
        }
    }
}