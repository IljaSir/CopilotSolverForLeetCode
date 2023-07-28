impl Solution {
    pub fn push_dominoes(dominoes: String) -> String {
        
        let mut states = vec![None; dominoes.len()];
        let mut prev = None;
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
        let mut prev = None;
        for i in (0..dominoes.len()).rev() {
            match states[i] {
                Some(c) => {
                    prev = Some(c);
                }
                None => {
                    if let Some(p) = prev {
                        states[i] = Some(p);
                    }
                }
            }
        }
        let mut result = String::new();
        for (i, c) in states.iter().enumerate() {
            match c {
                Some('L') => result.push('L'),
                Some('R') => result.push('R'),
                _ => {
                    if i > 0 && i < states.len() - 1 {
                        if states[i - 1] == Some('R') && states[i + 1] == Some('L') {
                            result.push('.');
                        } else if states[i - 1] == Some('R') {
                            result.push('R');
                        } else if states[i + 1] == Some('L') {
                            result.push('L');
                        } else {
                            result.push('.');
                        }
                    } else if i == 0 {
 
    }
}