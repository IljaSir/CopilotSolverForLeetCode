impl Solution {
    pub fn min_remove_to_make_valid(s: String) -> String {
        
        let mut s = s.into_bytes();
        let mut stack = Vec::new();
        for i in 0..s.len() {
            match s[i] {
                b'(' => stack.push(i),
                b')' => {
                    if let Some(j) = stack.pop() {
                        s[j] = b' ';
                    }
                    s[i] = b' ';
                }
                _ => (),
            }
        }
        String::from_utf8(s).unwrap().replace(" ", "")
    }
}