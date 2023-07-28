impl Solution {
    pub fn decode_ciphertext(encoded_text: String, rows: i32) -> String {
        
        let mut decoded = String::new();
        let mut encoded = encoded_text.chars().collect::<Vec<_>>();
        let mut index = 0;
        let mut step = 1;
        for _ in 0..rows {
            while index < encoded.len() {
                decoded.push(encoded[index]);
                index += step;
            }
            index = step / 2;
            step += 2;
        }
        decoded
    }
}