impl Solution {
    pub fn distance_between_bus_stops(distance: Vec<i32>, start: i32, destination: i32) -> i32 {
        
        let mut total = 0;
        let mut clockwise = 0;
        let mut i = start;
        while i != destination {
            total += distance[i as usize];
            clockwise += distance[i as usize];
            i = (i + 1) % distance.len() as i32;
        }
        let counter_clockwise = total - clockwise;
        clockwise.min(counter_clockwise)
    }
}