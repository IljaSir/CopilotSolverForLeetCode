impl Solution {
    pub fn max_number_of_balloons(text: String) -> i32 {
        
        let mut counter = [0; 26];
        for c in text.chars() {
            counter[(c as u8 - b'a') as usize] += 1;
        }
        let mut result = std::i32::MAX;
        for (i, c) in "balon".chars().enumerate() {
            let count = counter[(c as u8 - b'a') as usize];
            if i == 2 {
                result = result.min(count / 2);
            } else {
                result = result.min(count);
            }
        }
        result
    }
}