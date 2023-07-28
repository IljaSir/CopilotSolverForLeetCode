impl Solution {
    pub fn can_change(start: String, target: String) -> bool {
        
        let mut start = start.chars().collect::<Vec<char>>();
        let mut target = target.chars().collect::<Vec<char>>();
        let mut i = 0;
        while i < start.len() {
            if start[i] == target[i] {
                i += 1;
            } else if start[i] == '_' {
                let mut j = i + 1;
                while j < start.len() && start[j] == '_' {
                    j += 1;
                }
                if j < start.len() && start[j] == 'L' {
                    start[i] = 'L';
                    start[j] = '_';
                } else {
                    return false;
                }
            } else if start[i] == 'L' {
                let mut j = i + 1;
                while j < start.len() && start[j] == '_' {
                    j += 1;
                }
                if j < start.len() && start[j] == 'R' {
                    start[i] = '_';
                    start[j] = 'L';
                } else {
                    return false;
                }
            } else {
                let mut j = i + 1;
                while j < start.len() && start[j] == '_' {
                    j += 1;
                }
                if j < start.len() && start[j] == 'L' {
                    start[i] = '_';
                    start[j] = 'R';
                } else {
                    return false;
                }
            }
        }
        true
    }
}