impl Solution {
    pub fn remove_digit(number: String, digit: char) -> String {
        
        let mut s: Vec<char> = number.chars().collect();
        let mut i = 0;
        while i < s.len() {
            if s[i] == digit {
                s.remove(i);
                break;
            }
            i += 1;
        }
        s.into_iter().collect()
    }
}