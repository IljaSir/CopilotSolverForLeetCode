impl Solution {
    pub fn shortest_to_char(s: String, c: char) -> Vec<i32> {
        
        let mut result = vec![0; s.len()];
        let mut prev = -10000;
        for i in 0..s.len() {
            if s.chars().nth(i).unwrap() == c {
                prev = i as i32;
            }
            result[i] = i as i32 - prev;
        }
        prev = 10000;
        for i in (0..s.len()).rev() {
            if s.chars().nth(i).unwrap() == c {
                prev = i as i32;
            }
            result[i] = std::cmp::min(result[i], prev - i as i32);
        }
        result
    }
}