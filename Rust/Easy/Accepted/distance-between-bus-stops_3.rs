impl Solution {
    pub fn distance_between_bus_stops(distance: Vec<i32>, start: i32, destination: i32) -> i32 {
        
        let (start, destination) = (start as usize, destination as usize);
        let (mut clockwise, mut counter_clockwise) = (0, 0);
        let mut i = start;
        while i != destination {
            clockwise += distance[i];
            i = (i + 1) % distance.len();
        }
        i = destination;
        while i != start {
            counter_clockwise += distance[i];
            i = (i + 1) % distance.len();
        }
        clockwise.min(counter_clockwise)
    }
}