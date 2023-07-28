impl Solution {
    pub fn remove_digit(number: String, digit: char) -> String {
        
        let mut v = number.chars().collect::<Vec<char>>();
        let mut i = 0;
        while i < v.len() {
            if v[i] == digit {
                v.remove(i);
                break;
            }
            i += 1;
        }
        v.into_iter().collect()
    }
}