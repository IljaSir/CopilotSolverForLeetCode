impl Solution {
    pub fn corp_flight_bookings(bookings: Vec<Vec<i32>>, n: i32) -> Vec<i32> {
        
        let mut ans = vec![0; n as usize];
        for booking in bookings {
            let (first, last, seats) = (booking[0] as usize, booking[1] as usize, booking[2]);
            ans[first - 1] += seats;
            if last < n as usize {
                ans[last] -= seats;
            }
        }
        for i in 1..ans.len() {
            ans[i] += ans[i - 1];
        }
        ans
    }
}