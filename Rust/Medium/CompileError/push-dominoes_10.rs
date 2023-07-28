impl Solution {
    pub fn push_dominoes(dominoes: String) -> String {
        
        let n = dominoes.len();
        let mut res = vec!['.'; n];
        let mut last = -1;
        let mut last_dir = 'L';
        for (i, c) in dominoes.chars().enumerate() {
            if c == 'R' {
                if last_dir == 'L' {
                    let mid = (i - last) / 2;
                    for j in 0..mid {
                        res[last + 1 + j] = 'R';
                        res[i - 1 - j] = 'L';
                    }
                    if (i - last) % 2 == 1 {
                        res[last + mid + 1] = '.';
                    }
                } else {
                    for j in last + 1..i {
                        res[j] = 'R';
                    }
                }
                last = i as i32;
                last_dir = 'R';
            } else if c == 'L' {
                if last_dir == 'R' {
                    for j in last + 1..i {
                        res[j] = 'R';
                    }
                }
                last = i as i32;
                last_dir = 'L';
            }
        }
        if last_dir == 'R' {
            for j in last + 1..n {
                res[j] = 'R';
            }
        }
        res.into_iter().collect()
    }
}