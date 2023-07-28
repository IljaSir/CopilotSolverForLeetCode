impl Solution {
    pub fn is_match(s: String, p: String) -> bool {
        
        let mut s = s.chars();
        let mut p = p.chars();
        let mut s_match = None;
        let mut p_match = None;
        loop {
            match (s.next(), p.next()) {
                (Some(c), Some('?')) => (),
                (Some(c), Some('*')) => {
                    s_match = Some(s);
                    p_match = Some(p);
                }
                (Some(c), Some(d)) if c == d => (),
                (Some(c), None) => return false,
                (None, Some('*')) => (),
                (None, Some(_)) => return s_match.is_some(),
                (None, None) => return true,
                (Some(_), Some(_)) => {
                    if let Some(s) = s_match {
                        s_match = Some(s);
                        p_match = p_match.and_then(|mut p| p.next());
                        continue;
                    } else {
                        return false;
                    }
                }
            }
            if let Some(mut s) = s_match {
                s_match = s.next().map(|_| s);
            }
            if let Some(mut p) = p_match {
                p_match = p.next().map(|_| p);
            }
        }