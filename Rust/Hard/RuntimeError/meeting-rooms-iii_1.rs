impl Solution {
    pub fn most_booked(n: i32, meetings: Vec<Vec<i32>>) -> i32 {
        
        let mut rooms = vec![0; n as usize];
        for m in meetings {
            let (start, end) = (m[0] as usize, m[1] as usize);
            for i in start..end {
                rooms[i] += 1;
            }
        }
        rooms.iter().enumerate().max_by_key(|&(_, &v)| v).unwrap().0 as i32
    }
}