impl Solution {
    pub fn max_events(events: Vec<Vec<i32>>) -> i32 {
        
        let mut events = events;
        events.sort_by(|a, b| a[1].cmp(&b[1]));
        let mut day = 0;
        let mut count = 0;
        let mut i = 0;
        let mut visited = vec![false; 100001];
        while i < events.len() {
            day = day.max(events[i][0]);
            while day <= events[i][1] && visited[day as usize] {
                day += 1;
            }
            if day <= events[i][1] {
                visited[day as usize] = true;
                count += 1;
            }
            i += 1;
        }
        count
    }
}