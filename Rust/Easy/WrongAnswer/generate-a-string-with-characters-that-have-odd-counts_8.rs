impl Solution {
    pub fn generate_the_string(n: i32) -> String {
        
        let mut s: String = String::new();
        let n = n as usize;
        let mut c = 'a';
        if n % 2 == 0 {
            for _ in 0..n-1 {
                s.push(c);
            }
            c = 'b';
        }
        for _ in 0..n {
            s.push(c);
        }
        s
    }
}