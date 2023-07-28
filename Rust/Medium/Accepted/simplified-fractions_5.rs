impl Solution {
    pub fn simplified_fractions(n: i32) -> Vec<String> {
        
        let mut ans: Vec<String> = Vec::new();
        for i in 2..=n {
            for j in 1..i {
                if Solution::gcd(i, j) == 1 {
                    ans.push(format!("{}/{}", j, i));
                }
            }
        }
        ans
    }
    fn gcd(a: i32, b: i32) -> i32 {
        if b == 0 {
            a
        } else {
            Solution::gcd(b, a % b)
        }
    }
}