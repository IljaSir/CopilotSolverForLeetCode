impl Solution {
    pub fn decode_ciphertext(encoded_text: String, rows: i32) -> String {
        
        if rows == 1 {
            return encoded_text;
        }
        let mut encoded_text = encoded_text;
        let mut result = String::new();
        let mut index = 0;
        let mut step = 2 * rows - 2;
        while index < encoded_text.len() {
            result.push(encoded_text[index..index+1].parse().unwrap());
            index += step as usize;
        }
        for i in 1..rows-1 {
            index = i as usize;
            step = 2 * (rows - i - 1);
            while index < encoded_text.len() {
                result.push(encoded_text[index..index+1].parse().unwrap());
                index += step as usize;
                step = 2 * rows - 2 - step;
            }
        }
        index = rows as usize - 1;
        step = 2 * rows - 2;
        while index < encoded_text.len() {
            result.push(encoded_text[index..index+1].parse().unwrap());
            index += step as usize;
        }
        result
    }
}