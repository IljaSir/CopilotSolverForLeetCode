impl Solution {
    pub fn simplified_fractions(n: i32) -> Vec<String> {
        
        let mut ans = vec![];
        for i in 1..=n {
            for j in 1..i {
                if gcd(i, j) == 1 {
                    ans.push(format!("{}/{}", j, i));
                }
            }
        }
        ans
    }
}