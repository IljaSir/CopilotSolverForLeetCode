impl Solution {
    pub fn max_events(events: Vec<Vec<i32>>) -> i32 {
        
        let mut events = events;
        events.sort_by_key(|e| e[1]);
        let mut set = std::collections::HashSet::new();
        let mut i = 0;
        for e in events {
            let mut j = e[0];
            while j <= e[1] && i < e[1] {
                if !set.contains(&j) {
                    set.insert(j);
                    i += 1;
                    break;
                }
                j += 1;
            }
        }
        i
    }
}