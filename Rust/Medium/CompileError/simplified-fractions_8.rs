impl Solution {
    pub fn simplified_fractions(n: i32) -> Vec<String> {
        
        let mut result = Vec::new();
        for i in 1..n+1 {
            for j in 1..i {
                if Solution::gcd(i, j) == 1 {
                    result.push(format!("{}/{}", j, i));
                }
            }
        }
        result
    }
}