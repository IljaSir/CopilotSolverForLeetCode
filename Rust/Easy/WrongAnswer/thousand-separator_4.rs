impl Solution {
    pub fn thousand_separator(n: i32) -> String {
        
        if n < 1000 {
            return n.to_string();
        }
        let mut v = Vec::new();
        let mut n = n;
        while n > 0 {
            v.push(n % 1000);
            n /= 1000;
        }
        let mut s = String::new();
        for i in (0..v.len()).rev() {
            if i < v.len() - 1 {
                s.push('.');
            }
            s.push_str(&format!("{:03}", v[i]));
        }
        s
    }
}