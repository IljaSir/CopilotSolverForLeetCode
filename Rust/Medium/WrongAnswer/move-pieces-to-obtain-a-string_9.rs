impl Solution {
    pub fn can_change(start: String, target: String) -> bool {
        
        let mut s = start.chars();
        let mut t = target.chars();
        let mut start = s.next();
        let mut target = t.next();
        while start.is_some() && target.is_some() {
            if start.unwrap() != target.unwrap() && start.unwrap() != '_' && target.unwrap() != '_' {
                return false;
            }
            start = s.next();
            target = t.next();
        }
        true
    }
}