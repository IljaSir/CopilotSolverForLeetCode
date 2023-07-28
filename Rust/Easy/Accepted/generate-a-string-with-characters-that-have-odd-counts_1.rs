impl Solution {
    pub fn generate_the_string(n: i32) -> String {
        
        let mut s = String::new();
        if n % 2 == 0 {
            for _ in 0..n-1 {
                s.push('a');
            }
            s.push('b');
        } else {
            for _ in 0..n {
                s.push('a');
            }
        }
        s
    }
}