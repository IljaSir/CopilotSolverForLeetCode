impl Solution {
    pub fn car_pooling(trips: Vec<Vec<i32>>, capacity: i32) -> bool {
        
        let mut passengers = vec![0; 1001];
        for trip in trips {
            passengers[trip[1] as usize] += trip[0];
            passengers[trip[2] as usize] -= trip[0];
        }
        let mut capacity = capacity;
        for p in passengers {
            capacity -= p;
            if capacity < 0 {
                return false;
            }
        }
        true
    }
}