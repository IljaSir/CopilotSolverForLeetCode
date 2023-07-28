impl Solution {
    pub fn simplified_fractions(n: i32) -> Vec<String> {
        
        let mut result = Vec::new();
        for i in 2..=n {
            for j in 1..i {
                if gcd(i, j) == 1 {
                    result.push(format!("{}/{}", j, i));
                }
            }
        }
        result
    }
}