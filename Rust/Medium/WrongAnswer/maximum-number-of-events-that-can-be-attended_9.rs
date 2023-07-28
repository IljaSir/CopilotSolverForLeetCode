impl Solution {
    pub fn max_events(events: Vec<Vec<i32>>) -> i32 {
        
        let mut events = events;
        events.sort_by_key(|a| a[1]);
        let mut day = 0;
        let mut ans = 0;
        let mut i = 0;
        let mut pq = std::collections::BinaryHeap::new();
        while !pq.is_empty() || i < events.len() {
            if pq.is_empty() {
                day = events[i][0];
            }
            while i < events.len() && events[i][0] <= day {
                pq.push(std::cmp::Reverse(events[i][1]));
                i += 1;
            }
            pq.pop();
            ans += 1;
            day += 1;
            while !pq.is_empty() && pq.peek().unwrap().0 < day {
                pq.pop();
            }
        }
        ans
    }
}