impl Solution {
    pub fn can_transform(start: String, end: String) -> bool {
        
        let start: Vec<char> = start.chars().collect();
        let end: Vec<char> = end.chars().collect();
        let mut i = 0;
        let mut j = 0;
        while i < start.len() && j < end.len() {
            while i < start.len() && start[i] == 'X' {
                i += 1;
            }
            while j < end.len() && end[j] == 'X' {
                j += 1;
            }
            if i == start.len() && j == end.len() {
                return true;
            } else if i == start.len() || j == end.len() {
                return false;
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
        true
    }
}