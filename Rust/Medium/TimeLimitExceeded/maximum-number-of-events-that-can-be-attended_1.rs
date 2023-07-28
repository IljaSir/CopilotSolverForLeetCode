impl Solution {
    pub fn max_events(events: Vec<Vec<i32>>) -> i32 {
        
        let mut events = events;
        events.sort_by(|a, b| a[1].cmp(&b[1]));
        let mut used = vec![false; 100001];
        let mut res = 0;
        for e in events {
            for i in e[0]..=e[1] {
                if !used[i as usize] {
                    res += 1;
                    used[i as usize] = true;
                    break;
                }
            }
        }
        res
    }
}