impl Solution {
    pub fn greatest_letter(s: String) -> String {
        
        let mut s = s;
        s.make_ascii_uppercase();
        let mut letters = s.as_bytes();
        let mut max = 0;
        for i in 0..letters.len() {
            if letters[i] > max {
                max = letters[i];
            }
        }
        let mut result = String::new();
        for i in 0..letters.len() {
            if letters[i] == max && s.as_bytes()[i] != max {
                result.push(s.as_bytes()[i] as char);
            }
        }
        result
    }
}