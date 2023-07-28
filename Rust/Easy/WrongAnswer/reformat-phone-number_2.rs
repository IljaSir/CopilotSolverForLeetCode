impl Solution {
    pub fn reformat_number(number: String) -> String {
        
        let mut result = String::new();
        let mut count = 0;
        for c in number.chars() {
            if c.is_digit(10) {
                result.push(c);
                count += 1;
                if count == 3 {
                    result.push('-');
                    count = 0;
                }
            }
        }
        if count == 1 {
            result.insert(result.len() - 3, '-');
        }
        result.pop();
        result
    }
}