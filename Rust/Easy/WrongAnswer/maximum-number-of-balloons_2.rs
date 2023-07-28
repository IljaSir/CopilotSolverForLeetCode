impl Solution {
    pub fn max_number_of_balloons(text: String) -> i32 {
        
        let mut count = [0; 26];
        for c in text.chars() {
            count[c as usize - 'a' as usize] += 1;
        }
        let mut min = std::i32::MAX;
        for (i, c) in "balloon".chars().enumerate() {
            let n = count[c as usize - 'a' as usize];
            if i == 1 || i == 3 {
                min = std::cmp::min(min, n / 2);
            } else {
                min = std::cmp::min(min, n);
            }
        }
        min
    }
}