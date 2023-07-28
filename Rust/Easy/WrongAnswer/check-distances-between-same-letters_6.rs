impl Solution {
    pub fn check_distances(s: String, distance: Vec<i32>) -> bool {
        
        let mut last = [0;26];
        let mut first = true;
        for (i,c) in s.chars().enumerate() {
            let d = c as usize - 'a' as usize;
            if first {
                first = false;
            } else {
                if (i as i32 - last[d]) as i32 != distance[d] {
                    return false;
                }
            }
            last[d] = i as i32;
        }
        true
    }
}