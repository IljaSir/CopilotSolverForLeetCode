impl Solution {
    pub fn is_isomorphic(s: String, t: String) -> bool {
        
        let mut map1 = [0; 128];
        let mut map2 = [0; 128];
        for (i, c) in s.chars().enumerate() {
            if map1[c as usize] == 0 {
                map1[c as usize] = t.chars().nth(i).unwrap() as usize;
            }
            if map2[t.chars().nth(i).unwrap() as usize] == 0 {
                map2[t.chars().nth(i).unwrap() as usize] = c as usize;
            }
            if map1[c as usize] != t.chars().nth(i).unwrap() as usize || map2[t.chars().nth(i).unwrap() as usize] != c as usize {
                return false;
            }
        }
        true
    }
}