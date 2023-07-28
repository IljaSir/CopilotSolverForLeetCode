impl Solution {
    pub fn can_change(start: String, target: String) -> bool {
        
        let start = start.as_bytes();
        let target = target.as_bytes();
        let n = start.len();
        let mut i = 0;
        while i < n {
            if start[i] == target[i] {
                i += 1;
            } else {
                break;
            }
        }
        let mut j = n - 1;
        while j >= i {
            if start[j] == target[j] {
                j -= 1;
            } else {
                break;
            }
        }
        let mut count = 0;
        for k in i..=j {
            if start[k] == b'L' {
                count += 1;
            } else if start[k] == b'R' {
                count -= 1;
            }
        }
        count == 0
    }
}