impl Solution {
    pub fn push_dominoes(dominoes: String) -> String {
        
        let mut result = dominoes.clone();
        let mut last = '.';
        let mut last_i = 0;
        for (i, c) in dominoes.chars().enumerate() {
            match c {
                'R' => {
                    if last == 'R' {
                        for j in last_i..i {
                            result.as_bytes_mut()[j] = 'R' as u8;
                        }
                    }
                    last = 'R';
                    last_i = i;
                }
                'L' => {
                    if last == 'R' {
                        let mid = (i + last_i) / 2;
                        for j in last_i..mid {
                            result.as_bytes_mut()[j] = 'R' as u8;
                        }
                        for j in mid..i {
                            result.as_bytes_mut()[j] = 'L' as u8;
                        }
                    } else {
                        for j in last_i..i {
                            result.as_bytes_mut()[j] = 'L' as u8;
                        }
                    }
                    last = 'L';
                    last_i = i;
                }
                _ => {}
            }
        }
        if last == 'R' {
            for j in last_i..dominoes.len() {
                result.as_bytes_mut()[j] = 'R' as u8;
            }
        }
        result
    }
}