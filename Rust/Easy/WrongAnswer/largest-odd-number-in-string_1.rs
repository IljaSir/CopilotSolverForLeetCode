impl Solution {
    pub fn largest_odd_number(num: String) -> String {
        
        let mut ret = String::new();
        for c in num.chars() {
            if c == '1' || c == '3' || c == '5' || c == '7' || c == '9' {
                ret.push(c);
            }
        }
        ret
    }
}