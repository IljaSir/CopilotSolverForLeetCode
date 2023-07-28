impl Solution {
    pub fn push_dominoes(dominoes: String) -> String {
        
        let n = dominoes.len();
        let mut res = vec!['.'; n];
        let mut l = -1;
        let mut r = -1;
        for i in 0..n {
            if dominoes[i..].starts_with('L') {
                if l == -1 {
                    for j in 0..i {
                        res[j] = 'L';
                    }
                } else {
                    let mut j = l + 1;
                    while j < i {
                        res[j] = 'L';
                        j += 1;
                    }
                }
                l = i as i32;
            } else if dominoes[i..].starts_with('R') {
                if l == -1 {
                    r = i as i32;
                } else {
                    let mut j = l + 1;
                    let mut k = i as i32 - 1;
                    while j < k {
                        res[j as usize] = 'R';
                        res[k as usize] = 'L';
                        j += 1;
                        k -= 1;
                    }
                    if j == k {
                        res[j as usize] = '.';
                    }
                    l = i as i32;
                }
            }
        }
        if l != -1 {
            for j in (l + 1) as usize..n {
                res[j] = 'R';
            }
        } else if r != -1 {
            for j in r as usize..n {
                res[j] = 'R';
            }
        }
        res.iter().collect()
    }
}