impl Solution {
    pub fn is_transformable(s: String, t: String) -> bool {
        
        let mut pos = vec![vec![]; 10];
        for (i, c) in s.chars().enumerate() {
            pos[c as usize - '0' as usize].push(i);
        }
        for c in t.chars() {
            let c = c as usize - '0' as usize;
            if pos[c].is_empty() {
                return false;
            }
            let i = pos[c].remove(0);
            for j in 0..c {
                if !pos[j].is_empty() && pos[j][0] < i {
                    return false;
                }
            }
        }
        true
    }
}