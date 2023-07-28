impl Solution {
    pub fn is_transformable(s: String, t: String) -> bool {
        
        let mut s: Vec<char> = s.chars().collect();
        let mut t: Vec<char> = t.chars().collect();
        let mut pos: Vec<Vec<usize>> = vec![vec![]; 10];
        for i in 0..s.len() {
            let x = s[i] as usize - '0' as usize;
            pos[x].push(i);
        }
        for i in 0..t.len() {
            let x = t[i] as usize - '0' as usize;
            if pos[x].len() == 0 {
                return false;
            }
            let y = pos[x][0];
            for j in 0..x {
                if pos[j].len() > 0 && pos[j][0] < y {
                    return false;
                }
            }
            pos[x].remove(0);
        }
        true
    }
}