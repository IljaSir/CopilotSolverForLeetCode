impl Solution {
    pub fn car_pooling(trips: Vec<Vec<i32>>, capacity: i32) -> bool {
        
        let mut times = vec![0; 1001];
        for trip in trips {
            times[trip[1] as usize] += trip[0];
            times[trip[2] as usize] -= trip[0];
        }
        let mut now = 0;
        for time in times {
            now += time;
            if now > capacity {
                return false;
            }
        }
        true
    }
}