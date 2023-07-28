impl Solution {
    pub fn min_moves_to_seat(seats: Vec<i32>, students: Vec<i32>) -> i32 {
        
        let mut seats = seats;
        let mut students = students;
        seats.sort();
        students.sort();
        let mut count = 0;
        for i in 0..seats.len() {
            count += (seats[i] - students[i]).abs();
        }
        count
    }
}