impl Solution {
    pub fn can_transform(start: String, end: String) -> bool {
        
        let mut i = 0;
        let mut j = 0;
        let start: Vec<char> = start.chars().collect();
        let end: Vec<char> = end.chars().collect();
        while i < start.len() && j < end.len() {
            while i < start.len() && start[i] == 'X' {
                i += 1;
            }
            while j < end.len() && end[j] == 'X' {
                j += 1;
            }
            if i == start.len() || j == end.len() {
                break;
            }
            if start[i] != end[j] {
                return false;
            }
            if start[i] == 'L' && i < j {
                return false;
            }
            if start[i] == 'R' && i > j {
                return false;
            }
            i += 1;
            j += 1;
        }
        while i < start.len() {
            if start[i] != 'X' {
                return false;
            }
            i += 1;
        }
        while j < end.len() {
            if end[j] != 'X' {
                return false;
            }
            j += 1;
        }
        true
    }
}