impl Solution {
    pub fn shortest_to_char(s: String, c: char) -> Vec<i32> {
        
        let mut res = vec![];
        let mut last = -1;
        for (i, ch) in s.chars().enumerate() {
            if ch == c {
                last = i as i32;
            }
            res.push(i as i32 - last);
        }
        last = s.len() as i32;
        for i in (0..s.len()).rev() {
            if s.chars().nth(i).unwrap() == c {
                last = i as i32;
            }
            res[i] = res[i].min(last - i as i32);
        }
        res
    }
}