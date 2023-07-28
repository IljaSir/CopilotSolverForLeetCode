impl Solution {
    pub fn check_distances(s: String, distance: Vec<i32>) -> bool {
        
        let mut last = vec![None; 26];
        for (i, c) in s.chars().enumerate() {
            let c = c as usize - 'a' as usize;
            if let Some(last) = last[c] {
                if (i - last) as i32 != distance[c] {
                    return false;
                }
            }
            last[c] = Some(i);
        }
        true
    }
}