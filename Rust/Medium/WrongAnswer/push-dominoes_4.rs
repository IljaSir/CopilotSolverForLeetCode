impl Solution {
    pub fn push_dominoes(dominoes: String) -> String {
        
        let mut dominoes = dominoes.as_bytes().to_vec();
        let mut left = -1;
        let mut right = -1;
        for i in 0..dominoes.len() {
            if dominoes[i] == b'R' {
                right = i as i32;
            } else if dominoes[i] == b'L' {
                if right > left {
                    let mut j = right + 1;
                    let mut k = i as i32 - 1;
                    while j < k {
                        dominoes[j as usize] = b'R';
                        dominoes[k as usize] = b'L';
                        j += 1;
                        k -= 1;
                    }
                    if j == k {
                        dominoes[j as usize] = b'.';
                    }
                } else {
                    for j in (left + 1)..i as i32 {
                        dominoes[j as usize] = b'L';
                    }
                }
                left = i as i32;
            }
        }
        if right > left {
            for j in (left + 1)..dominoes.len() as i32 {
                dominoes[j as usize] = b'R';
            }
        }
        std::str::from_utf8(&dominoes).unwrap().to_string()
    }
}