impl Solution {
    pub fn shortest_to_char(s: String, c: char) -> Vec<i32> {
        
        let mut res = Vec::new();
        let mut index = -1;
        for (i, x) in s.char_indices() {
            if x == c {
                index = i as i32;
            }
            if index == -1 {
                res.push(i as i32);
            } else {
                res.push((i as i32 - index).abs());
            }
        }
        index = -1;
        for i in (0..s.len()).rev() {
            if s.chars().nth(i).unwrap() == c {
                index = i as i32;
            }
            if index != -1 {
                res[i] = res[i].min((i as i32 - index).abs());
            }
        }
        res
    }
}