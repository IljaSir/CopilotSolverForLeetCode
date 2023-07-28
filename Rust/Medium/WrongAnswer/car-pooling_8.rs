impl Solution {
    pub fn car_pooling(trips: Vec<Vec<i32>>, capacity: i32) -> bool {
        
        let mut events = vec![];
        for trip in trips {
            events.push((trip[1], trip[0]));
            events.push((trip[2], -trip[0]));
        }
        events.sort_by_key(|x| x.0);
        let mut cur = 0;
        for event in events {
            cur += event.1;
            if cur > capacity {
                return false;
            }
        }
        true
    }
}