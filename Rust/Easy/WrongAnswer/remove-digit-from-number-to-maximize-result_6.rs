impl Solution {
    pub fn remove_digit(number: String, digit: char) -> String {
        
        let mut ret = String::new();
        let mut flag = false;
        for c in number.chars() {
            if c == digit && !flag {
                flag = true;
            } else {
                ret.push(c);
            }
        }
        ret
    }
}