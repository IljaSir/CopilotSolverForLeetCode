impl Solution {
    pub fn distance_between_bus_stops(distance: Vec<i32>, start: i32, destination: i32) -> i32 {
        
        let mut sum = 0;
        let mut sum2 = 0;
        let mut start = start as usize;
        let mut destination = destination as usize;
        if start > destination {
            std::mem::swap(&mut start, &mut destination);
        }
        for i in 0..distance.len() {
            if i < start || i >= destination {
                sum += distance[i];
            } else {
                sum2 += distance[i];
            }
        }
        if sum < sum2 {
            sum
        } else {
            sum2
        }
    }
}