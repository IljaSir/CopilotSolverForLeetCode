impl Solution {
    pub fn can_change(start: String, target: String) -> bool {
        
        let start = start.as_bytes();
        let target = target.as_bytes();
        let mut i = 0;
        let mut j = 0;
        while i < start.len() && j < target.len() {
            if start[i] == b'_' {
                i += 1;
            } else if start[i] == target[j] {
                i += 1;
                j += 1;
            } else if start[i] != target[j] {
                return false;
            }
        }
        while i < start.len() {
            if start[i] != b'_' {
                return false;
            }
            i += 1;
        }
        while j < target.len() {
            if target[j] != b'_' {
                return false;
            }
            j += 1;
        }
        true
    }
}