impl Solution {
    pub fn car_pooling(trips: Vec<Vec<i32>>, capacity: i32) -> bool {
        
        let mut max = 0;
        let mut arr = vec![0; 1001];
        for i in 0..trips.len() {
            arr[trips[i][1] as usize] += trips[i][0];
            arr[trips[i][2] as usize] -= trips[i][0];
            if trips[i][2] > max { max = trips[i][2]; }
        }
        let mut sum = 0;
        for i in 0..=max as usize {
            sum += arr[i];
            if sum > capacity { return false; }
        }
        true
    }
}