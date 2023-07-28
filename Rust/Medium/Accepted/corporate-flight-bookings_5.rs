impl Solution {
    pub fn corp_flight_bookings(bookings: Vec<Vec<i32>>, n: i32) -> Vec<i32> {
        
        let mut res = vec![0; n as usize];
        for b in bookings {
            res[(b[0] - 1) as usize] += b[2];
            if b[1] < n { res[b[1] as usize] -= b[2]; }
        }
        for i in 1..n as usize {
            res[i] += res[i - 1];
        }
        res
    }
}