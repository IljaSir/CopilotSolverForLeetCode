impl Solution {
    pub fn distance_between_bus_stops(distance: Vec<i32>, start: i32, destination: i32) -> i32 {
        
        let mut d = distance;
        if start > destination {
            d.rotate_right(start as usize);
            d.rotate_left(destination as usize);
        } else {
            d.rotate_left(start as usize);
            d.rotate_right(destination as usize);
        }
        let mut sum = 0;
        for i in 1..d.len() {
            sum += d[i];
        }
        sum
    }
}