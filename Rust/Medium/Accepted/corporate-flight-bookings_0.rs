impl Solution {
    pub fn corp_flight_bookings(bookings: Vec<Vec<i32>>, n: i32) -> Vec<i32> {
        
        let mut ans = vec![0; n as usize];
        for booking in bookings {
            ans[booking[0] as usize - 1] += booking[2];
            if booking[1] < n {
                ans[booking[1] as usize] -= booking[2];
            }
        }
        for i in 1..n as usize {
            ans[i] += ans[i - 1];
        }
        ans
    }
}