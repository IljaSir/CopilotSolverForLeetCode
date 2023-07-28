impl Solution {
    pub fn distance_between_bus_stops(distance: Vec<i32>, start: i32, destination: i32) -> i32 {
        
        let mut sum = 0;
        let mut sum2 = 0;
        let mut i = start;
        let mut j = destination;
        if i > j {
            std::mem::swap(&mut i, &mut j);
        }
        while i < j {
            sum += distance[i as usize];
            i += 1;
        }
        while j < distance.len() as i32 {
            sum2 += distance[j as usize];
            j += 1;
        }
        j = 0;
        while j < start {
            sum2 += distance[j as usize];
            j += 1;
        }
        std::cmp::min(sum, sum2)
    }
}