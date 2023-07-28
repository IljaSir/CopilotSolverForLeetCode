impl Solution {
    pub fn distance_between_bus_stops(distance: Vec<i32>, start: i32, destination: i32) -> i32 {
        
        let mut s = start;
        let mut d = destination;
        if s > d {
            std::mem::swap(&mut s, &mut d);
        }
        let mut clockwise = 0;
        let mut counterclockwise = 0;
        for i in 0..distance.len() {
            if i as i32 >= s && i as i32 < d {
                clockwise += distance[i];
            } else {
                counterclockwise += distance[i];
            }
        }
        std::cmp::min(clockwise, counterclockwise)
    }
}