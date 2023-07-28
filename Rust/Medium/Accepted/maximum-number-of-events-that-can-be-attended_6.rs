impl Solution {
    pub fn max_events(events: Vec<Vec<i32>>) -> i32 {
        
        let mut events = events;
        events.sort_by_key(|e| e[0]);
        let mut pq = std::collections::BinaryHeap::new();
        let mut i = 0;
        let mut res = 0;
        for d in 1..100001 {
            while i < events.len() && events[i][0] == d {
                pq.push(std::cmp::Reverse(events[i][1]));
                i += 1;
            }
            while !pq.is_empty() && pq.peek().unwrap().0 < d {
                pq.pop();
            }
            if !pq.is_empty() {
                res += 1;
                pq.pop();
            }
        }
        res
    }
}