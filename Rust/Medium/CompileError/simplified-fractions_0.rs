impl Solution {
    pub fn simplified_fractions(n: i32) -> Vec<String> {
        
        let mut res = Vec::new();
        for i in 2..=n {
            for j in 1..i {
                if gcd(i, j) == 1 {
                    res.push(format!("{}/{}", j, i));
                }
            }
        }
        res
    }
}