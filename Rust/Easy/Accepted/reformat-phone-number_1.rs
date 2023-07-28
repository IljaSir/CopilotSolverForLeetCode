impl Solution {
    pub fn reformat_number(number: String) -> String {
        
        let mut number = number.replace(" ", "").replace("-", "");
        let mut result = String::new();
        while number.len() > 4 {
            result.push_str(&number[..3]);
            result.push('-');
            number = number[3..].to_string();
        }
        if number.len() == 4 {
            result.push_str(&number[..2]);
            result.push('-');
            result.push_str(&number[2..]);
        } else {
            result.push_str(&number);
        }
        result
    }
}