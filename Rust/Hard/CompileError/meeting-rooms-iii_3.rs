impl Solution {
    pub fn most_booked(n: i32, meetings: Vec<Vec<i32>>) -> i32 {
        
        let mut events = meetings.into_iter().map(|v| (v[0], 1)).collect::<Vec<_>>();
        events.extend(meetings.into_iter().map(|v| (v[1], -1)));
        events.sort_unstable_by_key(|v| v.0);
        let mut max = 0;
        let mut max_room = 0;
        let mut room = 0;
        for (_, delta) in events {
            room += delta;
            if room > max {
                max = room;
                max_room = room;
            }
        }
        max_room
    }
}