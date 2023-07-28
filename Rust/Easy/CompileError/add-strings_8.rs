impl Solution {
    pub fn add_strings(num1: String, num2: String) -> String {
        
        let mut r = String::new();
        let mut c = 0;
        let (mut n1, mut n2) = (num1.into_bytes(), num2.into_bytes());
        while !n1.is_empty() || !n2.is_empty() || c > 0 {
            if let Some(n) = n1.pop() { c += (n - b'0') as i32; }
            if let Some(n) = n2.pop() { c += (n - b'0') as i32; }
            r.push((c % 10 + b'0') as char);
            c /= 10;
        }
        r.chars().rev().collect()
    }
}