impl Solution {
    pub fn push_dominoes(dominoes: String) -> String {
        
        let mut dominoes = dominoes.as_bytes().to_vec();
        let mut changed = true;
        while changed {
            changed = false;
            let mut next = vec![b'.'; dominoes.len()];
            for i in 0..dominoes.len() {
                if dominoes[i] == b'L' {
                    if i > 0 && next[i-1] == b'.' {
                        next[i-1] = b'L';
                        changed = true;
                    }
                } else if dominoes[i] == b'R' {
                    if i < dominoes.len() - 1 && next[i+1] == b'.' {
                        next[i+1] = b'R';
                        changed = true;
                    }
                }
            }
            dominoes = next;
        }
        String::from_utf8(dominoes).unwrap()
    }
}