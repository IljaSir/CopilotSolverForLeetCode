impl Solution {
    pub fn smallest_number(pattern: String) -> String {
        
        let mut n = 0;
        let mut res = String::new();
        let mut s = vec![0; pattern.len()+1];
        for i in 0..pattern.len() {
            if pattern.as_bytes()[i] == 'I' as u8 {
                s[i] = n;
                n += 1;
            }
        }
        s[pattern.len()] = n;
        n += 1;
        for i in (0..pattern.len()).rev() {
            if pattern.as_bytes()[i] == 'D' as u8 {
                s[i] = n;
                n += 1;
            }
        }
        for i in s {
            res.push_str(&i.to_string());
        }
        res
    }
}