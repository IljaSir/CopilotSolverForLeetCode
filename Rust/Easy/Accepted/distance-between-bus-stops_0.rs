impl Solution {
    pub fn distance_between_bus_stops(distance: Vec<i32>, start: i32, destination: i32) -> i32 {
        
        let n = distance.len();
        let start = start as usize;
        let destination = destination as usize;
        let mut clockwise = 0;
        let mut counterclockwise = 0;
        for i in 0..n {
            if start < destination {
                if i >= start && i < destination {
                    clockwise += distance[i];
                } else {
                    counterclockwise += distance[i];
                }
            } else {
                if i >= destination && i < start {
                    counterclockwise += distance[i];
                } else {
                    clockwise += distance[i];
                }
            }
        }
        clockwise.min(counterclockwise)
    }
}