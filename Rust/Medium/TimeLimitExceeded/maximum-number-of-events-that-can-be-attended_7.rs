impl Solution {
    pub fn max_events(events: Vec<Vec<i32>>) -> i32 {
        
        let mut events = events;
        events.sort_unstable_by_key(|x| x[1]);
        let mut ans = 0;
        let mut used = vec![false; 100001];
        for e in events {
            for i in e[0]..=e[1] {
                if !used[i as usize] {
                    used[i as usize] = true;
                    ans += 1;
                    break;
                }
            }
        }
        ans
    }
}