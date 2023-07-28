impl Solution {
    pub fn can_transform(start: String, end: String) -> bool {
        
        let mut start = start.chars().collect::<Vec<_>>();
        let mut end = end.chars().collect::<Vec<_>>();
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
            }
            if i == start.len() || j == end.len() {
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