impl Solution {
    pub fn is_transformable(s: String, t: String) -> bool {
        
        let mut s = s.chars().map(|c| c.to_digit(10).unwrap() as usize).collect::<Vec<usize>>();
        let mut t = t.chars().map(|c| c.to_digit(10).unwrap() as usize).collect::<Vec<usize>>();
        let mut pos = vec![0; 10];
        for i in 0..s.len() {
            pos[s[i]] = i;
        }
        for i in 0..s.len() {
            let c = t[i];
            let p = pos[c];
            for j in 0..c {
                if pos[j] < p {
                    return false;
                }
            }
            for j in c + 1..10 {
                pos[j] -= 1;
            }
        }
        true
    }
}