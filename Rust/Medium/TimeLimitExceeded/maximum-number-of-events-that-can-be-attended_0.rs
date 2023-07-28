impl Solution {
    pub fn max_events(events: Vec<Vec<i32>>) -> i32 {
        
        let mut events = events;
        events.sort_by(|a, b| a[1].cmp(&b[1]));
        let mut seen = vec![false; 100001];
        let mut ans = 0;
        for e in events {
            for i in e[0]..=e[1] {
                if !seen[i as usize] {
                    seen[i as usize] = true;
                    ans += 1;
                    break;
                }
            }
        }
        ans
    }
}