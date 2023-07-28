impl Solution {
    pub fn decode_ciphertext(encoded_text: String, rows: i32) -> String {
        
        if rows == 1 {
            return encoded_text;
        }
        let mut result = String::new();
        let mut index = 0;
        let mut step = 1;
        let mut n = 0;
        let mut chars = encoded_text.chars();
        let mut char = chars.next();
        while char.is_some() {
            result.push(char.unwrap());
            n += 1;
            if n == rows {
                step = -1;
            } else if n == 1 {
                step = 1;
            }
            n += step;
            index += 2 * (rows - 1);
            char = chars.nth(index as usize);
        }
        result
    }
}