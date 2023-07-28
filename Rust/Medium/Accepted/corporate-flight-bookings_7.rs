impl Solution {
    pub fn corp_flight_bookings(bookings: Vec<Vec<i32>>, n: i32) -> Vec<i32> {
        
        let mut ans = vec![0; n as usize];
        for i in bookings {
            let (f, l, s) = (i[0] as usize - 1, i[1] as usize - 1, i[2]);
            ans[f] += s;
            if l < n as usize - 1 {
                ans[l + 1] -= s;
            }
        }
        for i in 1..n as usize {
            ans[i] += ans[i - 1];
        }
        ans
    }
}