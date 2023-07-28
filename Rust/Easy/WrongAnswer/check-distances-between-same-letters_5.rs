impl Solution {
    pub fn check_distances(s: String, distance: Vec<i32>) -> bool {
        
        let mut last = [0; 26];
        for (i, c) in s.chars().enumerate() {
            let c = c as usize - 'a' as usize;
            let diff = i - last[c];
            if distance[c] != 0 && diff != distance[c] as usize {
                return false;
            }
            last[c] = i;
        }
        true
    }
}