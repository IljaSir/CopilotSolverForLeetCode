impl Solution {
    pub fn shortest_to_char(s: String, c: char) -> Vec<i32> {
        
        let mut res = vec![0; s.len()];
        let mut prev = -1;
        for (i, ch) in s.char_indices() {
            if ch == c {
                prev = i as i32;
            }
            res[i] = i as i32 - prev;
        }
        prev = s.len() as i32;
        for (i, ch) in s.char_indices().rev() {
            if ch == c {
                prev = i as i32;
            }
            res[i] = res[i].min(prev - i as i32);
        }
        res
    }
}