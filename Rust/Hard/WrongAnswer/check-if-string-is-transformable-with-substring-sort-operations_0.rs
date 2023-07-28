impl Solution {
    pub fn is_transformable(s: String, t: String) -> bool {
        
        let mut s = s.chars().map(|c| c.to_digit(10).unwrap() as usize).collect::<Vec<usize>>();
        let mut t = t.chars().map(|c| c.to_digit(10).unwrap() as usize).collect::<Vec<usize>>();
        
        let mut pos = vec![0; 10];
        for i in 0..s.len() {
            pos[s[i]] = i;
        }
        
        for i in 0..t.len() {
            let mut j = pos[t[i]];
            while j < i {
                if s[j] < s[j+1] {
                    s.swap(j, j+1);
                } else {
                    return false;
                }
                j += 1;
            }
        }
        
        true
    }
}