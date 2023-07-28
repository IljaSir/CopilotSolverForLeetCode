impl Solution {
    pub fn can_transform(start: String, end: String) -> bool {
        
        let mut i = 0;
        let mut j = 0;
        let start = start.as_bytes();
        let end = end.as_bytes();
        while i < start.len() && j < end.len() {
            while i < start.len() && start[i] == b'X' {
                i += 1;
            }
            while j < end.len() && end[j] == b'X' {
                j += 1;
            }
            if i == start.len() && j == end.len() {
                return true;
            }
            if i == start.len() || j == end.len() {
                return false;
            }
            if start[i] != end[j] {
                return false;
            }
            if start[i] == b'L' && i < j {
                return false;
            }
            if start[i] == b'R' && i > j {
                return false;
            }
            i += 1;
            j += 1;
        }
        true
    }
}