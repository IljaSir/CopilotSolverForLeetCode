impl Solution {
    pub fn car_pooling(trips: Vec<Vec<i32>>, capacity: i32) -> bool {
        
        let mut record = vec![0; 1001];
        for trip in trips {
            record[trip[1] as usize] += trip[0];
            record[trip[2] as usize] -= trip[0];
        }
        let mut sum = 0;
        for i in 0..1001 {
            sum += record[i];
            if sum > capacity {
                return false;
            }
        }
        true
    }
}