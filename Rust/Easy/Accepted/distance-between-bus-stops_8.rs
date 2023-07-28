impl Solution {
    pub fn distance_between_bus_stops(distance: Vec<i32>, start: i32, destination: i32) -> i32 {
        
        let n = distance.len();
        let (mut sum, mut min) = (0, 0);
        for i in 0..n {
            sum += distance[i];
            let (s, d) = (start as usize, destination as usize);
            if (s < d && s <= i && i < d) || (s > d && (s <= i || i < d)) {
                min += distance[i];
            }
        }
        min.min(sum - min)
    }
}