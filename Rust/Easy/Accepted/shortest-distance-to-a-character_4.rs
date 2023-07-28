impl Solution {
    pub fn shortest_to_char(s: String, c: char) -> Vec<i32> {
        
        let mut v: Vec<i32> = Vec::new();
        let mut pos: Vec<usize> = Vec::new();
        for (i, ch) in s.chars().enumerate() {
            if ch == c {
                pos.push(i);
            }
        }
        for i in 0..s.len() {
            let mut min = s.len() as i32;
            for j in 0..pos.len() {
                let d = (i as i32 - pos[j] as i32).abs();
                if d < min {
                    min = d;
                }
            }
            v.push(min);
        }
        v
    }
}