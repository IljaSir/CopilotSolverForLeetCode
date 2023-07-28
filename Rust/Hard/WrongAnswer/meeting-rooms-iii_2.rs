impl Solution {
    pub fn most_booked(n: i32, meetings: Vec<Vec<i32>>) -> i32 {
        
        let mut events = Vec::new();
        for m in meetings {
            events.push((m[0], 1));
            events.push((m[1], -1));
        }
        events.sort();
        let mut max = 0;
        let mut curr = 0;
        let mut room = 0;
        for e in events {
            curr += e.1;
            if curr > max {
                max = curr;
                room = e.0;
            }
        }
        room
    }
}