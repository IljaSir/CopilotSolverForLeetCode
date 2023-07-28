impl Solution {
    pub fn most_booked(n: i32, meetings: Vec<Vec<i32>>) -> i32 {
        
        let mut rooms = vec![0; n as usize];
        let mut max = 0;
        for meeting in meetings {
            let (start, end) = (meeting[0] as usize, meeting[1] as usize);
            for i in start..end {
                rooms[i] += 1;
                max = max.max(rooms[i]);
            }
        }
        rooms.iter().position(|&x| x == max).unwrap() as i32
    }
}