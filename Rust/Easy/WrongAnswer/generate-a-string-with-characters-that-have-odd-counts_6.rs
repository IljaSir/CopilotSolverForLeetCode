impl Solution {
    pub fn generate_the_string(n: i32) -> String {
        
        let mut s = String::new();
        let mut c = 'a';
        for _ in 0..n-1 {
            s.push(c);
            c = (c as u8 + 1) as char;
        }
        if n % 2 == 0 {
            s.push(c);
        } else {
            s.push((c as u8 + 1) as char);
        }
        s
    }
}