impl Solution {
    pub fn car_pooling(trips: Vec<Vec<i32>>, capacity: i32) -> bool {
        
        let mut counts = vec![0; 1001];
        for trip in trips {
            counts[trip[1] as usize] += trip[0];
            counts[trip[2] as usize] -= trip[0];
        }
        let mut cur = 0;
        for count in counts {
            cur += count;
            if cur > capacity {
                return false;
            }
        }
        true
    }
}