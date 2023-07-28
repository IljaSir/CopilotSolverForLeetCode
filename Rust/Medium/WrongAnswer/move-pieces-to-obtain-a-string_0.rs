impl Solution {
    pub fn can_change(start: String, target: String) -> bool {
        
        let start: Vec<char> = start.chars().collect();
        let target: Vec<char> = target.chars().collect();
        let mut count = 0;
        for i in 0..start.len() {
            if start[i] == 'L' {
                count -= 1;
            } else if start[i] == 'R' {
                count += 1;
            }
            if target[i] == 'L' {
                count += 1;
            } else if target[i] == 'R' {
                count -= 1;
            }
        }
        count == 0
    }
}