impl Solution {
    pub fn shortest_to_char(s: String, c: char) -> Vec<i32> {
        
        let mut result: Vec<i32> = Vec::new();
        let mut index = -1;
        let mut i = 0;
        for ch in s.chars() {
            if ch == c {
                index = i as i32;
            } else {
                if index == -1 {
                    result.push(i as i32 - index);
                } else {
                    result.push(i32::min(i as i32 - index, index + (s.len() as i32 - i as i32)));
                }
            }
            i += 1;
        }
        result
    }
}