impl Solution {
    pub fn is_subsequence(s: String, t: String) -> bool {
        
        let mut s = s.chars();
        let mut t = t.chars();
        loop {
            match s.next() {
                Some(c) => {
                    let mut matched = false;
                    loop {
                        match t.next() {
                            Some(d) => {
                                if c == d {
                                    matched = true;
                                    break;
                                }
                            }
                            None => {
                                return false;
                            }
                        }
                    }
                    if !matched {
                        return false;
                    }
                }
                None => {
                    return true;
                }
            }
        }
    }
}