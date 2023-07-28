impl Solution {
    pub fn average_waiting_time(customers: Vec<Vec<i32>>) -> f64 {
        
        let mut time = 0;
        let mut wait_time = 0;
        for c in customers {
            time = time.max(c[0]) + c[1];
            wait_time += time - c[0];
        }
        wait_time as f64 / customers.len() as f64
    }
}