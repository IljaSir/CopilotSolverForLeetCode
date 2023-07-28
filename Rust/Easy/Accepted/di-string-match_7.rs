impl Solution {
    pub fn di_string_match(s: String) -> Vec<i32> {
        
        let mut v: Vec<i32> = Vec::new();
        let mut a = 0;
        let mut b = s.len() as i32;
        for c in s.chars() {
            if c == 'I' {
                v.push(a);
                a += 1;
            } else {
                v.push(b);
                b -= 1;
            }
        }
        v.push(a);
        v
    }
}