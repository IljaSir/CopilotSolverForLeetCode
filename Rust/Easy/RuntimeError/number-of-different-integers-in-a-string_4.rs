impl Solution {
    pub fn num_different_integers(word: String) -> i32 {
        
        let mut v: Vec<i32> = Vec::new();
        let mut s = String::new();
        for c in word.chars() {
            if c.is_digit(10) {
                s.push(c);
            } else {
                if !s.is_empty() {
                    let n = s.parse().unwrap();
                    if !v.contains(&n) {
                        v.push(n);
                    }
                    s.clear();
                }
            }
        }
        if !s.is_empty() {
            let n = s.parse().unwrap();
            if !v.contains(&n) {
                v.push(n);
            }
        }
        v.len() as i32
    }
}