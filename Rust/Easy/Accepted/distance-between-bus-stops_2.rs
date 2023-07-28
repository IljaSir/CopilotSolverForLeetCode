impl Solution {
    pub fn distance_between_bus_stops(distance: Vec<i32>, start: i32, destination: i32) -> i32 {
        
        let mut clockwise = 0;
        let mut counter_clockwise = 0;
        let (mut start, mut destination) = (start as usize, destination as usize);
        if start > destination {
            std::mem::swap(&mut start, &mut destination);
        }
        for i in start..destination {
            clockwise += distance[i];
        }
        for i in 0..start {
            counter_clockwise += distance[i];
        }
        for i in destination..distance.len() {
            counter_clockwise += distance[i];
        }
        clockwise.min(counter_clockwise)
    }
}