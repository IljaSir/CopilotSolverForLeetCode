impl Solution {
    pub fn corp_flight_bookings(bookings: Vec<Vec<i32>>, n: i32) -> Vec<i32> {
        
        let mut ans = vec![0; n as usize];
        for booking in bookings {
            let (first, last, seats) = (booking[0] as usize - 1, booking[1] as usize - 1, booking[2]);
            ans[first] += seats;
            if last + 1 < n as usize {
                ans[last + 1] -= seats;
            }
        }
        for i in 1..n as usize {
            ans[i] += ans[i - 1];
        }
        ans
    }
}