impl Solution {
    pub fn check_distances(s: String, distance: Vec<i32>) -> bool {
        
        let mut dist = distance;
        let mut chrs = s.chars().collect::<Vec<char>>();
        let mut i = 0;
        while i < chrs.len() {
            if chrs[i] == chrs[i + 1] {
                if dist[chrs[i] as usize - 97] == 0 {
                    return false;
                }
                dist[chrs[i] as usize - 97] -= 1;
                chrs.remove(i);
                chrs.remove(i);
                i = 0;
            } else {
                i += 1;
            }
        }
        true
    }
}