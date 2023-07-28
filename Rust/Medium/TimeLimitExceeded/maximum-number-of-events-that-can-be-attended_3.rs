impl Solution {
    pub fn max_events(events: Vec<Vec<i32>>) -> i32 {
        
        let mut events = events;
        events.sort_unstable_by(|a, b| a[1].cmp(&b[1]));
        let mut set = std::collections::HashSet::new();
        for event in events {
            for i in event[0]..event[1] + 1 {
                if !set.contains(&i) {
                    set.insert(i);
                    break;
                }
            }
        }
        set.len() as i32
    }
}