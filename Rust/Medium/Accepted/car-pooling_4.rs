impl Solution {
    pub fn car_pooling(trips: Vec<Vec<i32>>, capacity: i32) -> bool {
        
        let mut arr = vec![0; 1001];
        for trip in trips {
            arr[trip[1] as usize] += trip[0];
            arr[trip[2] as usize] -= trip[0];
        }
        let mut sum = 0;
        for i in arr {
            sum += i;
            if sum > capacity {
                return false;
            }
        }
        true
    }
}