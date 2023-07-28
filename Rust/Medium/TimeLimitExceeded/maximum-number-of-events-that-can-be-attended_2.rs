impl Solution {
    pub fn max_events(events: Vec<Vec<i32>>) -> i32 {
        
        let mut events = events;
        events.sort_by(|a, b| a[1].cmp(&b[1]));
        let mut seen = vec![false; 100001];
        let mut count = 0;
        for event in events {
            let mut i = event[0];
            while i <= event[1] {
                if !seen[i as usize] {
                    seen[i as usize] = true;
                    count += 1;
                    break;
                }
                i += 1;
            }
        }
        count
    }
}