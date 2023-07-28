impl Solution {
    pub fn distance_between_bus_stops(distance: Vec<i32>, start: i32, destination: i32) -> i32 {
        
        let mut clock_wise = 0;
        let mut counter_clock_wise = 0;
        let mut i = start;
        while i != destination {
            clock_wise += distance[i as usize];
            i = (i + 1) % distance.len() as i32;
        }
        i = destination;
        while i != start {
            counter_clock_wise += distance[i as usize];
            i = (i + 1) % distance.len() as i32;
        }
        clock_wise.min(counter_clock_wise)
    }
}