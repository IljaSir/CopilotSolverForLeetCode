impl Solution {
    pub fn can_transform(start: String, end: String) -> bool {
        
        let mut start = start.into_bytes();
        let mut end = end.into_bytes();
        let mut i = 0;
        let mut j = 0;
        while i < start.len() && j < end.len() {
            while i < start.len() && start[i] == b'X' { i += 1; }
            while j < end.len() && end[j] == b'X' { j += 1; }
            if i == start.len() || j == end.len() { break; }
            if start[i] != end[j] { return false; }
            if start[i] == b'L' && i < j { return false; }
            if start[i] == b'R' && i > j { return false; }
            i += 1;
            j += 1;
        }
        while i < start.len() { if start[i] != b'X' { return false; } i += 1; }
        while j < end.len() { if end[j] != b'X' { return false; } j += 1; }
        true
    }
}