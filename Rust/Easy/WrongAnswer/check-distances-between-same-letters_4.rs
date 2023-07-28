impl Solution {
    pub fn check_distances(s: String, distance: Vec<i32>) -> bool {
        
        let mut last = vec![0; 26];
        let mut i = 0;
        for c in s.chars() {
            i += 1;
            let d = distance[c as usize - 'a' as usize];
            if d == 0 { continue; }
            if i - last[c as usize - 'a' as usize] != d as usize + 1 {
                return false;
            }
            last[c as usize - 'a' as usize] = i;
        }
        true
    }
}