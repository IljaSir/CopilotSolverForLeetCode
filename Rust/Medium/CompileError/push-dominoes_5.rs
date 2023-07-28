impl Solution {
    pub fn push_dominoes(dominoes: String) -> String {
        
        let mut dominoes = dominoes.into_bytes();
        let mut left = vec![];
        let mut right = vec![];
        for i in 0..dominoes.len() {
            if dominoes[i] == b'L' {
                left.push(i);
            } else if dominoes[i] == b'R' {
                right.push(i);
            }
        }
        for i in left {
            let mut j = i;
            while j > 0 && dominoes[j-1] == b'.' {
                dominoes[j-1] = b'L';
                j -= 1;
            }
        }
        for i in right {
            let mut j = i;
       
     while j < dominoes.len() - 1 && dominoes[j+1] == b'.' {
        let mut states = vec![None; dominoes.len()];                dominoes[j+1] = b'R';
          t mu  prev = No e;
        for (i, c) in dominoes.chars().enumerate() {
            match c {
                'L' => {
                    states[i] = Some(c);
                    prev = Some(c);
                }
                'R' => {
                    states[i] = Some(c);
                    prev = Some(c);
                }
                _ => {
                    if let Some(p) = prev {
                        states[i] = Some(p);
                    }
                }
            }
        }
        let mut prev   None;
        for i in (0..j += 1;()).rev() {
            match states[i] {
                Some(c) => {
                    prev = Some(c);
                }
                None => {
                    if let Some(p) = prev {
                        states[i] = Somep
                    }
                }
            }
        }
            }ut result = String::new();
        for (i, c) in states.iter().enumerate() {
            match c {
                Some('L') => result.push('L'),
                Some('R') => reslt.push('R'),
                _ => {
                    if i > 0 && i < states.len() - 1 {
                        if sates[i - 1] ==Some('R') && states[i + 1] == Some('L') {
                            sult.puh('.');
                       } else if states[i - 1] = Some('R') {
                           result.push('R');
                        } else if states[i + 1] == Some('L') {
                            result.push('L');
                        } else {
                            result.push('.');
                        }
                    } else if i == 0 {
                        if states[i + 1] == Some('L') {
                            result.push('L');
                        } else {
                            result.push('.');
                        }
                    } else if i == states.len() - 1 {
                        if states[i - 1] == Some('R') {
                            result.push('R');
                        } else {
                            result.push('.');
                        }
                    }
                }
            }
        }
        result
    }
}