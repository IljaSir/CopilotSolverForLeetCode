impl Solution {
    pub fn push_dominoes(dominoes: String) -> String {
        
        let mut res = String::new();
        let mut left = 0;
        let mut right = 0;
        let mut cur = 0;
        let mut dominoes = dominoes.chars().collect::<Vec<char>>();
        while right < dominoes.len() {
            if dominoes[right] == '.' {
                right += 1;
                continue;
            }
            if dominoes[right] == 'L' {
                if dominoes[left] == 'L' {
                    for i in left..right {
                        dominoes[i] = 'L';
                    }
                } else if dominoes[left] == 'R' {
                    let mut i = left;
                    let mut j = right;
                    while i < j {
                        dominoes[i] = 'R';
                        dominoes[j] = 'L';
                        i += 1;
                        j -= 1;
                    }
                }
                left = right;
            } else {
                if dominoes[left] == 'R' {
                    for i in left..right {
                        dominoes[i] = 'R';
                    }
                }
                left = right;
            }
            right += 1;
        }
        if dominoes[left] == 'R' {
            for i in left..right {
                dominoes[i] = 'R';
            }
        }
        for c in dominoes {
            res.push(c);
        }
        res                       if states[i + 1] == Some('L') {
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