impl Solution {
    pub fn generate_the_string(n: i32) -> String {
        
        if n % 2 == 0 {
            let mut s = String::new();
            for _ in 0..n-1 {
                s.push('a');
            }
            s.push('z');
            s
        } else {
            let mut s = String::new();
            for _ in 0..n {
                s.push('a');
            }
            s
        }
    }
}