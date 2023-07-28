impl Solution {
    pub fn car_pooling(trips: Vec<Vec<i32>>, capacity: i32) -> bool {
        
        let mut stops = vec![0; 1001];
        for trip in trips {
            stops[trip[1] as usize] += trip[0];
            stops[trip[2] as usize] -= trip[0];
        }
        let mut cur = 0;
        for stop in stops {
            cur += stop;
            if cur > capacity {
                return false;
            }
        }
        true
    }
}